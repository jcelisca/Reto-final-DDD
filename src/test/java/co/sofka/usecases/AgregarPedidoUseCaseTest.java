package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.carrito.command.AgregarPedido;
import co.sofka.domain.carrito.events.CarritoCreado;
import co.sofka.domain.carrito.events.PedidoAgregado;
import co.sofka.domain.carrito.value.CarritoId;
import co.sofka.domain.carrito.value.Catalogo;
import co.sofka.domain.pedido.value.PedidoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AgregarPedidoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarPedido(){
        //arrange
        var carritoId = CarritoId.of("ffff");
        var pedidoId = PedidoId.of("xxxx");
        var command = new AgregarPedido(carritoId, pedidoId);

        var usecase = new AgregarPedidoUseCase();
        Mockito.when(repository.getEventsBy("ffff")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(carritoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PedidoAgregado)events.get(0);
        Assertions.assertEquals("carrito.pedidoagregado",event.type);
        Assertions.assertEquals("xxxx", event.getPedidoId().value());
    }

    private List<DomainEvent> history(){
        List<String> lista = new ArrayList();
        lista.add("item 1");
        lista.add("item 2");
        return List.of(
                new CarritoCreado(new Catalogo(lista)),
                new PedidoAgregado(PedidoId.of("gggg"))
        );
    }
}
