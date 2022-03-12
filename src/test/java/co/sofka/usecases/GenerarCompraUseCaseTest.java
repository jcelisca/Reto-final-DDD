package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.carrito.command.GenerarCompra;
import co.sofka.domain.carrito.entity.value.CompraId;
import co.sofka.domain.carrito.entity.value.DetallesDeCompra;
import co.sofka.domain.carrito.events.CarritoCreado;
import co.sofka.domain.carrito.events.CompraGenerada;
import co.sofka.domain.carrito.value.CarritoId;
import co.sofka.domain.carrito.value.Catalogo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GenerarCompraUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void generarCompra(){

        //arrange
        var carritoId = CarritoId.of("ffff");
        var compraId = CompraId.of("xxxx");
        var detalles = new DetallesDeCompra("detalles de la compra reaizada");
        var command = new GenerarCompra(carritoId, compraId, detalles);

        var usecase = new GenerarCompraUseCase();
        Mockito.when(repository.getEventsBy("ffff")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(carritoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CompraGenerada)events.get(0);
        Assertions.assertEquals("xxxx", event.getCompraId().value());
        Assertions.assertEquals("detalles de la compra reaizada", event.getDetallesDeCompra().value());

    }

    private List<DomainEvent> history(){
        List<String> lista = new ArrayList();
        lista.add("item 1");
        lista.add("item 2");
        DetallesDeCompra detalles = new DetallesDeCompra("detalles de la compra reaizada");
        return List.of(
                new CarritoCreado(new Catalogo(lista)),
                new CompraGenerada(CompraId.of("1"),detalles)
        );
    }
}
