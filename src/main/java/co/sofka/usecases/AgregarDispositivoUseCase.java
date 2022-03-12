package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.carrito.Carrito;
import co.sofka.domain.carrito.command.AgregarDispositivo;

public class AgregarDispositivoUseCase extends UseCase<RequestCommand<AgregarDispositivo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDispositivo> input) {
        var command = input.getCommand();
        var carrito = Carrito.from(command.getCarritoId(), retrieveEvents());
        carrito.agregarDispositivo(command.getDispositivoId());
        emit().onResponse(new ResponseEvents(carrito.getUncommittedChanges()));
    }
}
