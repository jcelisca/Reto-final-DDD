package co.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.pedido.entity.value.Estado;
import co.sofka.domain.pedido.value.PedidoId;

public class CambiarEstadoDeEnvio extends Command {
    private final PedidoId pedidoId;
    private final Estado estado;

    public CambiarEstadoDeEnvio(PedidoId pedidoId, Estado estado) {
        this.pedidoId = pedidoId;
        this.estado = estado;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Estado getEstado() {
        return estado;
    }
}
