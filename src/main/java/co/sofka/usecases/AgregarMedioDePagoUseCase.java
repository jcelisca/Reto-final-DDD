package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.pedido.Pedido;
import co.sofka.domain.pedido.command.AgregarMedioDePago;

public class AgregarMedioDePagoUseCase extends UseCase<RequestCommand<AgregarMedioDePago>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMedioDePago> input) {
        var command = input.getCommand();
        var pedido = Pedido.from(command.getPedidoId(), retrieveEvents());
        pedido.agregarMedioDePago(command.getMedioDePago());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
