package co.sofka.domain.carrito.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.carrito.entity.value.CompraId;
import co.sofka.domain.carrito.entity.value.DetallesDeCompra;

public class CompraGenerada extends DomainEvent {
    private final CompraId compraId;
    private final DetallesDeCompra detallesDeCompra;

    public CompraGenerada(CompraId compraId, DetallesDeCompra detallesDeCompra) {
        super("carrito.compragenerada");
        this.compraId = compraId;
        this.detallesDeCompra = detallesDeCompra;
    }

    public CompraId getCompraId() {
        return compraId;
    }

    public DetallesDeCompra getDetallesDeCompra() {
        return detallesDeCompra;
    }
}
