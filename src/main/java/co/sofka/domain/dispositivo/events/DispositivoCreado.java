package co.sofka.domain.dispositivo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.dispositivo.entity.value.CelularId;

public class DispositivoCreado extends DomainEvent {
    private final CelularId celularId;

    public DispositivoCreado(CelularId celularId) {
        super("dispositivo.dispositivocreado");
        this.celularId = celularId;
    }

    public CelularId getCelularId() {
        return celularId;
    }
}
