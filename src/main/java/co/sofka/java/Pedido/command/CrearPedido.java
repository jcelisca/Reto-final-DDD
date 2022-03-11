package co.sofka.java.Pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.java.Pedido.entity.Estado;
import co.sofka.java.Pedido.value.PedidoId;

public class CrearPedido extends Command {
    private final PedidoId  pedidoId;
    private final Estado estado;

    public CrearPedido(PedidoId pedidoId, Estado estado) {
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
