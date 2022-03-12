package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.carrito.Carrito;
import co.sofka.domain.carrito.command.GenerarCompra;

public class GenerarCompraUseCase extends UseCase<RequestCommand<GenerarCompra>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<GenerarCompra> input) {
        var command = input.getCommand();
        var carrito = Carrito.from(command.getCarritoId(), retrieveEvents());
        carrito.generarCompra(command.getCompraId(), command.getDetallesDeCompra());
        emit().onResponse(new ResponseEvents(carrito.getUncommittedChanges()));
    }
}
