package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.command.AgregarCliente;
import co.sofka.domain.pedido.entity.value.ClienteId;
import co.sofka.domain.pedido.entity.value.DatosPersonales;
import co.sofka.domain.pedido.entity.value.EnvioId;
import co.sofka.domain.pedido.entity.value.FacturaId;
import co.sofka.domain.pedido.events.ClienteAgregado;
import co.sofka.domain.pedido.events.PedidoCreado;
import co.sofka.domain.pedido.value.PedidoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AgregarClienteUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarCliente(){
        //arrange
        var pedidoId = PedidoId.of("dddd");
        var clienteId = ClienteId.of("hhhh");
        var datosPersonales = new DatosPersonales("Juan","Perez","juan@email.com","32456789");
        var command = new AgregarCliente(pedidoId,clienteId,datosPersonales);

        var usecase = new AgregarClienteUseCase();
        Mockito.when(repository.getEventsBy("dddd")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(pedidoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ClienteAgregado)events.get(0);
        Assertions.assertEquals("pedido.clienteagregado", event.type);
        Assertions.assertEquals("hhhh", event.getClienteId().value());
        Assertions.assertEquals(datosPersonales, event.getDatosPersonales());
    }
    private List<DomainEvent> history(){
        var datosPersonales1 = new DatosPersonales("Pedro","Perez","pedro@email.com","89456789");
        return List.of(
                new PedidoCreado(EnvioId.of("dddd")),
                new ClienteAgregado(ClienteId.of("1"),datosPersonales1)
        );
    }
}
