package co.sofka.domain.carrito.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.carrito.entity.value.ArticuloId;
import co.sofka.domain.carrito.entity.value.Cantidad;
import co.sofka.domain.carrito.entity.value.EnStock;
import co.sofka.domain.carrito.value.CarritoId;

public class CambiarCantidadArticulo extends Command {
    private final CarritoId carritoId;
    private final ArticuloId articuloId;
    private final Cantidad cantidad;

    public CambiarCantidadArticulo(CarritoId carritoId, ArticuloId articuloId, Cantidad cantidad) {
        this.carritoId = carritoId;
        this.articuloId = articuloId;
        this.cantidad = cantidad;
    }

    public ArticuloId getArticuloId() {
        return articuloId;
    }

    public CarritoId getCarritoId() {
        return carritoId;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
