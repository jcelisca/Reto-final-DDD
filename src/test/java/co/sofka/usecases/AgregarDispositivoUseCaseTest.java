package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.carrito.command.AgregarDispositivo;
import co.sofka.domain.carrito.events.CarritoCreado;
import co.sofka.domain.carrito.events.DispositivoAgregado;
import co.sofka.domain.carrito.value.CarritoId;
import co.sofka.domain.carrito.value.Catalogo;
import co.sofka.domain.dispositivo.value.DispositivoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AgregarDispositivoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarDispositivo(){
        //arrange
        var carritoId = CarritoId.of("ffff");
        var dispositivoId = DispositivoId.of("gggg");
        var command = new AgregarDispositivo(carritoId, dispositivoId);

        var usecase = new AgregarDispositivoUseCase();
        Mockito.when(repository.getEventsBy("ffff")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(carritoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DispositivoAgregado)events.get(0);
        Assertions.assertEquals("carrito.dispositivoagregado", event.type);
        Assertions.assertEquals("gggg", event.getDispositivoId().value());

    }

    private List<DomainEvent> history(){
        List<String> lista = new ArrayList();
        lista.add("item 1");
        lista.add("item 2");
        return List.of(
                new CarritoCreado(new Catalogo(lista)),
                new DispositivoAgregado(DispositivoId.of("23"))
        );
    }
}
