package co.sofka.domain.carrito.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.carrito.value.CarritoId;
import co.sofka.domain.pedido.value.PedidoId;

public class AgregarPedido extends Command {
    private final CarritoId carritoId;
    private final PedidoId pedidoId;

    public AgregarPedido(CarritoId carritoId, PedidoId pedidoId) {
        this.carritoId = carritoId;
        this.pedidoId = pedidoId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public CarritoId getCarritoId() {
        return carritoId;
    }
}
