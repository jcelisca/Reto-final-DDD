package co.sofka.domain.dispositivo.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.domain.dispositivo.entity.value.Descuento;
import co.sofka.domain.dispositivo.entity.value.PromocionId;

import java.util.Objects;

public class Promocion extends Entity<PromocionId> {
    private Descuento descuento;

    public Promocion(PromocionId entityId, Descuento descuento) {
        super(entityId);
        this.descuento = descuento;
    }

    //Comportamiento
    public void actualizarDescuento(Descuento descuento){
        this.descuento = Objects.requireNonNull(descuento);
    }

    public Descuento descuento() {
        return descuento;
    }

}
