package co.sofka.domain.carrito.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.carrito.entity.value.Cantidad;

public class CantidadArticuloCambiada extends DomainEvent {
    private final Cantidad cantidad;

    public CantidadArticuloCambiada( Cantidad cantidad) {
        super("carrito.cantidadarticuloactualizada");
        this.cantidad = cantidad;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
