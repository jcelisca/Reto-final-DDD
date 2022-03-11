package co.sofka.domain.carrito.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.domain.carrito.entity.value.Cantidad;
import co.sofka.domain.carrito.entity.value.ArticuloId;
import co.sofka.domain.carrito.entity.value.EnStock;

import java.util.Objects;

public class Articulo extends Entity<ArticuloId> {
    private Cantidad cantidad;
    private EnStock enStock;

    public Articulo(ArticuloId entityId, Cantidad cantidad) {
        super(entityId);
        this.cantidad = cantidad;
        this.enStock = new EnStock(EnStock.State.DSPONIBLE);
    }

    //Comportamientos
    public void cambiarCantidad(Cantidad cantidad){
        this.cantidad = Objects.requireNonNull(cantidad);
    }

    public void cambiarStock(){
        this.enStock = new EnStock(EnStock.State.NO_DISPONIBLE);
    }

    public Cantidad cantidad() {
        return cantidad;
    }

    public EnStock enStock() {
        return enStock;
    }
}
