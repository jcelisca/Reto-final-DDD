package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.sofka.domain.carrito.command.CrearCarrito;
import co.sofka.domain.carrito.events.CarritoCreado;
import co.sofka.domain.carrito.value.CarritoId;
import co.sofka.domain.carrito.value.Catalogo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CrearCarritoUseCaseTest {

    @Test
    void crearCarrito(){
        List<String> lista = new ArrayList();
        lista.add("item 1");
        lista.add("item 2");
        lista.add("item 3");

        //arrange
        CarritoId carritoId = new CarritoId();
        Catalogo catalogo = new Catalogo(lista);
        var command = new CrearCarrito(carritoId, catalogo);
        var usecase = new CrearCarritoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CarritoCreado)events.get(0);
        Assertions.assertEquals("carrito.carritocreado", event.type);
        Assertions.assertEquals(carritoId.value(), event.aggregateRootId());
        Assertions.assertEquals(lista, event.getCatalogo().value());
    }
}
