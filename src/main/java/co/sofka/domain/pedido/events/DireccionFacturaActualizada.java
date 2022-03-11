package co.sofka.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.entity.value.Direccion;

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
