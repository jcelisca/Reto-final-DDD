package co.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.sofka.domain.dispositivo.command.CrearDispositivo;
import co.sofka.domain.dispositivo.entity.value.CelularId;
import co.sofka.domain.dispositivo.events.DispositivoCreado;
import co.sofka.domain.dispositivo.value.DispositivoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrearDispositivoUseCaseTest {

    @Test
    void crearDispositivo(){
        //arrange
        DispositivoId dispositivoId = new DispositivoId();
        var celularId = CelularId.of("ffff");
        var command = new CrearDispositivo(dispositivoId,celularId);
        var usecase = new CrearDispositivoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DispositivoCreado)events.get(0);
        Assertions.assertEquals("dispositivo.dispositivocreado", event.type);
        Assertions.assertEquals(dispositivoId.value(), event.aggregateRootId());
        Assertions.assertEquals("ffff", event.getCelularId().value());
    }
}
