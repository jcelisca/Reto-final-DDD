package co.sofka.domain.carrito.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.carrito.value.CarritoId;
import co.sofka.domain.carrito.value.Catalogo;

public class CrearCarrito extends Command {
    private final CarritoId carritoId;
    private final Catalogo catalogo;

    public CrearCarrito(CarritoId carritoId, Catalogo catalogo) {
        this.carritoId = carritoId;
        this.catalogo = catalogo;
    }

    public CarritoId getCarritoId() {
        return carritoId;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }
}
