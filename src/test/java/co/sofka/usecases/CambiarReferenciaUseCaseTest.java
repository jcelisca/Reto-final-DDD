package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.dispositivo.command.CambiarReferencia;
import co.sofka.domain.dispositivo.entity.value.Audifonos;
import co.sofka.domain.dispositivo.entity.value.Cargador;
import co.sofka.domain.dispositivo.entity.value.CelularId;
import co.sofka.domain.dispositivo.entity.value.ReferenciaId;
import co.sofka.domain.dispositivo.events.DispositivoCreado;
import co.sofka.domain.dispositivo.events.ReferenciaCambiada;
import co.sofka.domain.dispositivo.value.DispositivoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CambiarReferenciaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarReferencia(){
        //arrange
        var dispositivoId = DispositivoId.of("ffff");
        var referenciaId = ReferenciaId.of("gggg");
        var audifonos = new Audifonos(Audifonos.State.NO_INCLUYE);
        var cargador = new Cargador(Cargador.State.NO_INCLUYE);
        var command = new CambiarReferencia(dispositivoId, referenciaId, audifonos, cargador);

        var usecase = new CambiarReferenciaUseCase();
        Mockito.when(repository.getEventsBy("ffff")).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(dispositivoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ReferenciaCambiada)events.get(0);
        Assertions.assertEquals("dispositivo.refrenciacambiada", event.type);
        Assertions.assertEquals("gggg",event.getReferenciaId().value());
        Assertions.assertEquals(cargador.value(), event.getCargador().value());
        Assertions.assertEquals(audifonos.value(), event.getAudifonos().value());
    }

    private List<DomainEvent> history(){
        var audifonos = new Audifonos(Audifonos.State.INCLUYE);
        var cargador = new Cargador(Cargador.State.INCLUYE);
        return List.of(
                new DispositivoCreado(CelularId.of("2")),
                new ReferenciaCambiada(ReferenciaId.of("56"), audifonos, cargador)
        );
    }
}
