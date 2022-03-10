package co.sofka.java.Pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.java.Pedido.entity.value.Direccion;

public class DireccionFacturaActualizada extends DomainEvent {
    private final Direccion direccion;

    public DireccionFacturaActualizada(Direccion direccion) {
        super("pedido.direccionfacturaActualizada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
