package co.sofka.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.entity.value.Direccion;
import co.sofka.domain.pedido.entity.value.FacturaId;
import co.sofka.domain.pedido.entity.value.Fecha;

public class FacturaGenerada extends DomainEvent {
    private final FacturaId facturaId;
    private final Fecha fecha;
    private final Direccion direccion;

    public FacturaGenerada(FacturaId facturaId, Fecha fecha, Direccion direccion) {
        super("pedido.facturagenerada");
        this.facturaId = facturaId;
        this.fecha = fecha;
        this.direccion = direccion;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
