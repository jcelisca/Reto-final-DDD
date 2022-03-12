package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.pedido.Pedido;
import co.sofka.domain.pedido.command.AgregarCliente;

public class AgregarClienteUseCase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> input) {
        var command = input.getCommand();
        var pedido = Pedido.from(command.getPedidoId(), retrieveEvents());
        pedido.agregarCliente(command.getClienteId(),command.getDatosPersonales());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
