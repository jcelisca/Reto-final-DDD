package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.dispositivo.Dispositivo;
import co.sofka.domain.dispositivo.command.CrearDispositivo;

public class CrearDispositivoUseCase extends UseCase<RequestCommand<CrearDispositivo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearDispositivo> input) {
        var command = input.getCommand();
        var disspositivo = new Dispositivo(command.getDispositivoId(), command.getCelularId());
        emit().onResponse(new ResponseEvents(disspositivo.getUncommittedChanges()));
    }
}
