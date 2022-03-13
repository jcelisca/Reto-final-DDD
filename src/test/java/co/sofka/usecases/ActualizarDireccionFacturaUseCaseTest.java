package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.command.ActualizarDireccionFactura;
import co.sofka.domain.pedido.entity.value.Direccion;
import co.sofka.domain.pedido.entity.value.EnvioId;
import co.sofka.domain.pedido.entity.value.FacturaId;
import co.sofka.domain.pedido.entity.value.Fecha;
import co.sofka.domain.pedido.events.DireccionFacturaActualizada;
import co.sofka.domain.pedido.events.FacturaGenerada;
import co.sofka.domain.pedido.events.PedidoCreado;
import co.sofka.domain.pedido.value.PedidoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ActualizarDireccionFacturaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarDireccion(){
        //arrange
        var pedidoId = PedidoId.of("dddd");
        var direccion = new Direccion("Bogota", "Carrera 45");
        var command = new ActualizarDireccionFactura(pedidoId,direccion);

        var usecase = new ActualizarDireccionFacturaUseCase();
        Mockito.when(repository.getEventsBy("dddd")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(pedidoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DireccionFacturaActualizada)events.get(0);
        Assertions.assertEquals("pedido.direccionfacturaActualizada", event.type);
        Assertions.assertEquals(direccion, event.getDireccion());
    }

    private List<DomainEvent> history(){
        return List.of(
                new PedidoCreado(EnvioId.of("dddd")),
                new FacturaGenerada(FacturaId.of("1"),
                        new Fecha(LocalDate.of(2021,10,10)),
                        new Direccion("Medellin","Calle 2"))
        );
    }
}
