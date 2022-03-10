package co.sofka.java.Pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.java.Pedido.entity.Estado;

public class PedidoCreado extends DomainEvent {
    private final Estado estado;

    public PedidoCreado(Estado estado) {
        super("pedido.pedidocreado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
