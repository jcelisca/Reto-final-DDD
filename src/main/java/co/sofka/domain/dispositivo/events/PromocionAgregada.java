package co.sofka.domain.dispositivo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.dispositivo.entity.value.Descuento;
import co.sofka.domain.dispositivo.entity.value.PromocionId;

public class PromocionAgregada extends DomainEvent {
    private final PromocionId promocionId;
    private final Descuento descuento;

    public PromocionAgregada(PromocionId promocionId, Descuento descuento) {
        super("dispositivo.promocionagregada");
        this.promocionId = promocionId;
        this.descuento = descuento;
    }

    public PromocionId getPromocionId() {
        return promocionId;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
