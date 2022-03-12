package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.dispositivo.Dispositivo;
import co.sofka.domain.dispositivo.command.CambiarReferencia;

public class CambiarReferenciaUseCase extends UseCase<RequestCommand<CambiarReferencia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarReferencia> input) {
        var command = input.getCommand();
        var dispositivo = Dispositivo.from(command.getDispositivoId(), retrieveEvents());
        dispositivo.cambiarReferencia(command.getReferenciaId(), command.getAudifonos(), command.getCargador());
        emit().onResponse(new ResponseEvents(dispositivo.getUncommittedChanges()));
    }
}
