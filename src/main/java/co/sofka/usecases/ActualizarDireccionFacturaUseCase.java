package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.pedido.Pedido;
import co.sofka.domain.pedido.command.ActualizarDireccionFactura;

public class ActualizarDireccionFacturaUseCase extends UseCase<RequestCommand<ActualizarDireccionFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDireccionFactura> input) {
        var command = input.getCommand();
        var pedido = Pedido.from(command.getPedidoId(), retrieveEvents());
        pedido.actualizarDireccionFactura(command.getDireccion());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
