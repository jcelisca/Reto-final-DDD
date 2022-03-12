package co.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.sofka.domain.pedido.Pedido;
import co.sofka.domain.pedido.command.CrearPedido;

public class CrearPedidoUseCase extends UseCase<RequestCommand<CrearPedido>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPedido> input) {
        var command = input.getCommand();
        var pedido = new Pedido(command.getPedidoId(), command.getEnvioId());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
