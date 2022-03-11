package co.sofka.domain.carrito.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.value.PedidoId;

public class PedidoAgregado extends DomainEvent {
    private final PedidoId pedidoId;

    public PedidoAgregado(PedidoId pedidoId) {
        super("carrito.pedidoagregado");
        this.pedidoId = pedidoId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
