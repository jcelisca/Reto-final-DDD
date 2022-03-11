package co.sofka.java.Pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.java.Pedido.entity.value.Direccion;
import co.sofka.java.Pedido.value.PedidoId;

public class ActualizarDireccionFactura extends Command {
    private final PedidoId pedidoId;
    private final Direccion direccion;

    public ActualizarDireccionFactura(PedidoId pedidoId, Direccion direccion) {
        this.pedidoId = pedidoId;
        this.direccion = direccion;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
