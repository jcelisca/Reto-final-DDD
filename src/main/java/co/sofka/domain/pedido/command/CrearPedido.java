package co.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.pedido.entity.value.EnvioId;
import co.sofka.domain.pedido.value.PedidoId;

public class CrearPedido extends Command {
    private final PedidoId  pedidoId;
    private final EnvioId envioId;

    public CrearPedido(PedidoId pedidoId, EnvioId envioId) {
        this.pedidoId = pedidoId;
        this.envioId =envioId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public EnvioId getEnvioId() {
        return envioId;
    }
}
