package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.command.GenerarFactura;
import co.sofka.domain.pedido.entity.value.Direccion;
import co.sofka.domain.pedido.entity.value.EnvioId;
import co.sofka.domain.pedido.entity.value.FacturaId;
import co.sofka.domain.pedido.entity.value.Fecha;
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
public class GenerarFacturaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void generarFactura(){
        //arrange
        var peidoId = PedidoId.of("dddd");
        var facturaId = FacturaId.of("gggg");
        var fecha = new Fecha(LocalDate.now());
        var direccion = new Direccion("Medellin","Calle 23");
        var command = new GenerarFactura(peidoId, facturaId, fecha, direccion);

        var usecase = new GenerarFacturaUseCase();
        Mockito.when(repository.getEventsBy("dddd")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(peidoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (FacturaGenerada)events.get(0);
        Assertions.assertEquals("pedido.facturagenerada", event.type);
        Assertions.assertEquals("gggg", event.getFacturaId().value());
        Assertions.assertEquals(fecha, event.getFecha());
        Assertions.assertEquals(direccion,event.getDireccion());

    }

    private List<DomainEvent> history() {
        var fecha1 = new Fecha(LocalDate.of(2021,10,10));
        var direccion1 = new Direccion("Medellin","Calle 2");
        return List.of(
                new PedidoCreado(EnvioId.of("dddd")),
                new FacturaGenerada(FacturaId.of("1"), fecha1, direccion1)
        );
    }

}
