package co.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.carrito.entity.value.CompraId;
import co.sofka.domain.carrito.entity.value.DetallesDeCompra;
import co.sofka.domain.carrito.events.CarritoCreado;
import co.sofka.domain.carrito.events.CompraGenerada;
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
public class NotificarCompraGeneradaUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Mock
    private NotificacionService service;

    @Test
    void notificarCompraGenerada(){
        //arrange
        var compraId = CompraId.of("dddd");
        var detallesDeCompra = new DetallesDeCompra("Se realizo la compra de un dispositivo");
        var event = new CompraGenerada(compraId, detallesDeCompra);
        event.setAggregateRootId("ffff");

        var usecase = new NotificarCompraGeneradaUseCase();
        Mockito.when(repository.getEventsBy("carrito","ffff")).thenReturn(history());
        Mockito.when(service.enviarNotificacionContabilidad(Mockito.any(CompraId.class),Mockito.anyString())).thenReturn(true);

        usecase.addRepository(repository);
        usecase.addServiceBuilder(new ServiceBuilder().addService(service));

        //act
        var isPresent = UseCaseHandler.getInstance()
                .setIdentifyExecutor("ffff")
                .syncExecutor(usecase, new TriggeredEvent<>(event)).isPresent();

        //assert
        Assertions.assertTrue(isPresent);
    }

    @Test
    void problemaConEnvioDeNotificacion(){
        //arrange
        var compraId = CompraId.of("dddd");
        var detallesDeCompra = new DetallesDeCompra("Se realizo la compra de un dispositivo");
        var event = new CompraGenerada(compraId, detallesDeCompra);
        event.setAggregateRootId("ffff");

        var usecase = new NotificarCompraGeneradaUseCase();
        Mockito.when(repository.getEventsBy("carrito","ffff")).thenReturn(history());
        Mockito.when(service.enviarNotificacionContabilidad(Mockito.any(CompraId.class),Mockito.anyString())).thenReturn(false);

        usecase.addRepository(repository);
        usecase.addServiceBuilder(new ServiceBuilder().addService(service));

        //act
        var mensaje = Assertions.assertThrows(BusinessException.class, () ->{
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor("ffff")
                    .syncExecutor(usecase, new TriggeredEvent<>(event));
        }).getMessage();

        //assert
        Assertions.assertEquals("No se puede enviar la notificacion",mensaje);
    }

    private List<DomainEvent> history(){
        List<String> lista = new ArrayList();
        lista.add("item 1");
        lista.add("item 2");
        return List.of(
                new CarritoCreado(new Catalogo(lista)),
                new CompraGenerada(CompraId.of("1"),
                        new DetallesDeCompra("Se realizo una compra de x dispositivo"))
        );
    }
}
