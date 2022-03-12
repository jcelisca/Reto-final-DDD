package co.sofka.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.entity.value.Estado;

public class EstadoDeEnvioCambiado extends DomainEvent {
    private final Estado estado;

    public EstadoDeEnvioCambiado(Estado estado) {
        super("pedido.estadodeenviocambiaado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
