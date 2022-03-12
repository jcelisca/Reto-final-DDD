package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.carrito.Carrito;
import co.sofka.domain.carrito.command.CrearCarrito;

public class CrearCarritoUseCase extends UseCase<RequestCommand<CrearCarrito>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCarrito> input) {
        var command = input.getCommand();
        var carrito = new Carrito(command.getCarritoId(), command.getCatalogo());
        emit().onResponse(new ResponseEvents(carrito.getUncommittedChanges()));
    }
}
