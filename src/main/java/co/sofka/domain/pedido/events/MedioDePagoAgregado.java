package co.sofka.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.value.MedioDePago;

public class MedioDePagoAgregado extends DomainEvent {
    private final MedioDePago medioDePago;

    public MedioDePagoAgregado(MedioDePago medioDePago) {
        super("pedido.mediodepagoagregado");
        this.medioDePago = medioDePago;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }
}
