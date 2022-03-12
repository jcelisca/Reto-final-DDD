package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.sofka.domain.pedido.command.CrearPedido;
import co.sofka.domain.pedido.entity.value.EnvioId;
import co.sofka.domain.pedido.events.PedidoCreado;
import co.sofka.domain.pedido.value.PedidoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrearPedidoUseCaseTest {

    @Test
    void crearPedido(){

        //arrange
        PedidoId pedidoId = new PedidoId();
        EnvioId envioId = EnvioId.of("dddd");
        var command = new CrearPedido(pedidoId,envioId);
        var usecase = new CrearPedidoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PedidoCreado)events.get(0);
        Assertions.assertEquals("pedido.pedidocreado", event.type);
        Assertions.assertEquals(pedidoId.value(), event.aggregateRootId());
        Assertions.assertEquals("dddd", event.getEnvio().identity().value());
    }
}
