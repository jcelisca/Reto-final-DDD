package co.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.sofka.domain.pedido.Pedido;
import co.sofka.domain.pedido.events.EstadoDeEnvioCambiado;
import co.sofka.domain.pedido.value.PedidoId;

import java.util.List;

public class NotificarCambioDeEstadoUseCase extends UseCase<TriggeredEvent<EstadoDeEnvioCambiado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<EstadoDeEnvioCambiado> input) {
        var event = input.getDomainEvent();
        var service = getService(EmailService.class).orElseThrow();

        var events = repository().getEventsBy("pedido", event.aggregateRootId());
        var pedido = Pedido.from(PedidoId.of(event.aggregateRootId()), events);

        var esOk = service.enviarEmailAlCliente(
                pedido.cliente().identity(),
                String.format("Se envio correctamente el email"));

        if(esOk){
            emit().onResponse(new ResponseEvents(List.of()));
        }else {
            throw new BusinessException(event.aggregateRootId(),"No se puede enviar el email");
        }
    }
}
