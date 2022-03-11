package co.sofka.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.domain.pedido.entity.value.Direccion;
import co.sofka.domain.pedido.entity.value.FacturaId;
import co.sofka.domain.pedido.entity.value.Fecha;

import java.util.Objects;

public class Factura extends Entity<FacturaId> {
    private Fecha fecha;
    private Direccion direccion;

    public Factura(FacturaId entityId, Fecha fecha, Direccion direccion) {
        super(entityId);
        this.fecha = fecha;
        this.direccion = direccion;
    }

    //Comportamientos
    public void actualizarDireccion(Direccion direccion){
        this.direccion = Objects.requireNonNull(direccion);
    }

    public void cambiarFecha(Fecha fecha){
        this.fecha = Objects.requireNonNull(fecha);
    }

    public Fecha fecha() {
        return fecha;
    }

    public Direccion direccion() {
        return direccion;
    }
}
