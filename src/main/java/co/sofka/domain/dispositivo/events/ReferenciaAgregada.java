package co.sofka.domain.dispositivo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.dispositivo.entity.value.Audifonos;
import co.sofka.domain.dispositivo.entity.value.Cargador;
import co.sofka.domain.dispositivo.entity.value.ReferenciaId;

public class ReferenciaAgregada extends DomainEvent {
    private final ReferenciaId referenciaId;
    private final Audifonos audifonos;
    private final Cargador cargador;

    public ReferenciaAgregada(ReferenciaId referenciaId, Audifonos audifonos, Cargador cargador) {
        super("dispositivo.refrenciaagregada");
        this.referenciaId = referenciaId;
        this.audifonos = audifonos;
        this.cargador = cargador;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public Audifonos getAudifonos() {
        return audifonos;
    }

    public Cargador getCargador() {
        return cargador;
    }
}
