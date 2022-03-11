package co.sofka.domain.carrito.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.dispositivo.value.DispositivoId;

public class DispositivoAgregado extends DomainEvent {
    private final DispositivoId dispositivoId;

    public DispositivoAgregado(DispositivoId dispositivoId) {
        super("carrito.dispositivoagregado");
        this.dispositivoId = dispositivoId;
    }

    public DispositivoId getDispositivoId() {
        return dispositivoId;
    }
}
