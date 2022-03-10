package co.sofka.java.Pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.java.Pedido.entity.value.Direccion;
import co.sofka.java.Pedido.entity.value.FacturaId;
import co.sofka.java.Pedido.entity.value.Fecha;

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

    public Fecha Fecha() {
        return fecha;
    }

    public Direccion Direccion() {
        return direccion;
    }
}
