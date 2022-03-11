package co.sofka.domain.carrito.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.carrito.value.Catalogo;

public class CarritoCreado extends DomainEvent {
    private final Catalogo catalogo;

    public CarritoCreado(Catalogo catalogo) {
        super("carrito.carritocreado");
        this.catalogo = catalogo;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }
}
