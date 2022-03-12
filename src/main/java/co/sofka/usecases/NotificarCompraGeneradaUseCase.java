package co.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.sofka.domain.carrito.Carrito;
import co.sofka.domain.carrito.events.CompraGenerada;
import co.sofka.domain.carrito.value.CarritoId;

import java.util.List;

public class NotificarCompraGeneradaUseCase extends UseCase<TriggeredEvent<CompraGenerada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CompraGenerada> input) {
        var event = input.getDomainEvent();
        var service = getService(NotificacionService.class).orElseThrow();

        var events = repository().getEventsBy("carrito", event.aggregateRootId());
        var carrito = Carrito.from(CarritoId.of(event.aggregateRootId()), events);

        var esOk = service.enviarNotificacionContabilidad(
                carrito.compra().identity(),
                String.format("Se envio correctamente la notificación"));

        if(esOk){
            emit().onResponse(new ResponseEvents(List.of()));
        }else {
            throw new BusinessException(event.aggregateRootId(),"No se puede enviar la notificacion");
        }
    }
}
