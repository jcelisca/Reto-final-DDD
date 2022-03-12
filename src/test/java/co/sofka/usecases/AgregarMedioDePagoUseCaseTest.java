package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.command.AgregarMedioDePago;
import co.sofka.domain.pedido.entity.value.EnvioId;
import co.sofka.domain.pedido.events.MedioDePagoAgregado;
import co.sofka.domain.pedido.events.PedidoCreado;
import co.sofka.domain.pedido.value.MedioDePago;
import co.sofka.domain.pedido.value.PedidoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AgregarMedioDePagoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarMedioDePago(){

        //arrange
        var pedidoId = PedidoId.of("dddd");
        var medioDePago = new MedioDePago("Tarjeta de Credito");
        var command = new AgregarMedioDePago(pedidoId,medioDePago);

        var usecase = new AgregarMedioDePagoUseCase();
        Mockito.when(repository.getEventsBy("dddd")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(pedidoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MedioDePagoAgregado)events.get(0);
        Assertions.assertEquals("pedido.mediodepagoagregado", event.type);
        Assertions.assertEquals("Tarjeta de Credito",event.getMedioDePago().value());
    }

    private List<DomainEvent> history(){
        var medioPago = new MedioDePago("efectivo");
        return List.of(
                new PedidoCreado(EnvioId.of("dddd")),
                new MedioDePagoAgregado(medioPago)
        );
    }
}
