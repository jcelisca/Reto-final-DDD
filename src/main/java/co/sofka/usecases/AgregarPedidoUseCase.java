package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.carrito.Carrito;
import co.sofka.domain.carrito.command.AgregarPedido;

public class AgregarPedidoUseCase extends UseCase<RequestCommand<AgregarPedido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPedido> input) {
        var command = input.getCommand();
        var carrito = Carrito.from(command.getCarritoId(), retrieveEvents());
        carrito.agregarPedido(command.getPedidoId());
        emit().onResponse(new ResponseEvents(carrito.getUncommittedChanges()));
    }
}
