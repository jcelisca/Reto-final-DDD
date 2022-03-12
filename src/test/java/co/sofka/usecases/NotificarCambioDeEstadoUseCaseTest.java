package co.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.entity.value.ClienteId;
import co.sofka.domain.pedido.entity.value.DatosPersonales;
import co.sofka.domain.pedido.entity.value.EnvioId;
import co.sofka.domain.pedido.entity.value.Estado;
import co.sofka.domain.pedido.events.ClienteAgregado;
import co.sofka.domain.pedido.events.EstadoDeEnvioCambiado;
import co.sofka.domain.pedido.events.PedidoCreado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NotificarCambioDeEstadoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Mock
    private EmailService service;

    @Test
    void enviarEmailAlCliente(){
        //arrange
        var estado = new Estado(Estado.State.ENTREGADO);
        var event = new EstadoDeEnvioCambiado(estado);
        event.setAggregateRootId("ffff");

        var usecase = new NotificarCambioDeEstadoUseCase();
        Mockito.when(repository.getEventsBy("pedido","ffff")).thenReturn(history());
        Mockito.when(service.enviarEmailAlCliente(Mockito.any(ClienteId.class),Mockito.anyString())).thenReturn(true);

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
    void problemaConEnvioDeEmail(){
        //arrange
        var estado = new Estado(Estado.State.ENTREGADO);
        var event = new EstadoDeEnvioCambiado(estado);
        event.setAggregateRootId("ffff");

        var usecase = new NotificarCambioDeEstadoUseCase();
        Mockito.when(repository.getEventsBy("pedido","ffff")).thenReturn(history());
        Mockito.when(service.enviarEmailAlCliente(Mockito.any(ClienteId.class),Mockito.anyString())).thenReturn(false);

        usecase.addRepository(repository);
        usecase.addServiceBuilder(new ServiceBuilder().addService(service));

        //act
        var mensaje = Assertions.assertThrows(BusinessException.class, () ->{
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor("ffff")
                    .syncExecutor(usecase, new TriggeredEvent<>(event));
        }).getMessage();

        //assert
        Assertions.assertEquals("No se puede enviar el email",mensaje);
    }

    private List<DomainEvent> history(){
        return List.of(
                new PedidoCreado(EnvioId.of("xxxx")),
                new ClienteAgregado(ClienteId.of("dddd"),
                        new DatosPersonales("Juan","perez","juan@email.com","567893"))
        );
    }
}
