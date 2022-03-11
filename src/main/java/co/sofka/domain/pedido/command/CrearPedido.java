package co.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.pedido.entity.Envio;
import co.sofka.domain.pedido.value.PedidoId;

public class CrearPedido extends Command {
    private final PedidoId  pedidoId;
    private final Envio estado;

    public CrearPedido(PedidoId pedidoId, Envio estado) {
        this.pedidoId = pedidoId;
        this.estado = estado;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Envio getEstado() {
        return estado;
    }
}
