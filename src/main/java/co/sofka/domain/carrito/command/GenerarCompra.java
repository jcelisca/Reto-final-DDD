package co.sofka.domain.carrito.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.carrito.entity.value.CompraId;
import co.sofka.domain.carrito.entity.value.DetallesDeCompra;
import co.sofka.domain.carrito.value.CarritoId;

public class GenerarCompra extends Command {
    private final CarritoId carritoId;
    private final CompraId compraId;
    private final DetallesDeCompra detallesDeCompra;

    public GenerarCompra(CarritoId carritoId, CompraId compraId, DetallesDeCompra detallesDeCompra) {
        this.carritoId = carritoId;
        this.compraId = compraId;
        this.detallesDeCompra = detallesDeCompra;
    }

    public CompraId getCompraId() {
        return compraId;
    }

    public DetallesDeCompra getDetallesDeCompra() {
        return detallesDeCompra;
    }

    public CarritoId getCarritoId() {
        return carritoId;
    }
}
