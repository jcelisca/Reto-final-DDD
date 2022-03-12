package co.sofka.domain.dispositivo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.dispositivo.entity.value.Especificaciones;

public class AlmacenamientoCelularActualizado extends DomainEvent {
    private final Especificaciones especificaciones;

    public AlmacenamientoCelularActualizado(Especificaciones especificaciones) {
        super("dispositivo.almacenamientoactualizado");
        this.especificaciones = especificaciones;
    }

    public Especificaciones getEspecificaciones() {
        return especificaciones;
    }

}
