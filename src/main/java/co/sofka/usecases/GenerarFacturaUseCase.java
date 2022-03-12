package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.pedido.Pedido;
import co.sofka.domain.pedido.command.GenerarFactura;

public class GenerarFacturaUseCase extends UseCase<RequestCommand<GenerarFactura>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<GenerarFactura> input) {
        var command = input.getCommand();
        var pedido = Pedido.from(command.getPedidoId(), retrieveEvents());
        pedido.generarFactura(command.getFacturaId(), command.getFecha(), command.getDireccion());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
