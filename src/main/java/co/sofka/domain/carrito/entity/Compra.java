package co.sofka.domain.carrito.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.domain.carrito.entity.value.CompraId;
import co.sofka.domain.carrito.entity.value.DetallesDeCompra;

import java.util.Objects;

public class Compra extends Entity<CompraId> {
    private DetallesDeCompra detallesDeCompra;

    public Compra(CompraId entityId, DetallesDeCompra detallesDeCompra) {
        super(entityId);
        this.detallesDeCompra = detallesDeCompra;
    }

    //Comportamiento
    public void actualizarGuiaCompra(DetallesDeCompra detallesDeCompra){
        this.detallesDeCompra = Objects.requireNonNull(detallesDeCompra);
    }

    public DetallesDeCompra detallesDeCompra() {
        return detallesDeCompra;
    }
}
