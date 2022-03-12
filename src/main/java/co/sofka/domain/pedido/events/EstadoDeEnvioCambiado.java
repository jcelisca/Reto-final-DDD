package co.sofka.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.entity.value.EnvioId;
import co.sofka.domain.pedido.entity.value.Estado;

public class EstadoDeEnvioCambiado extends DomainEvent {
    private final EnvioId envioId;
    private final Estado estado;

    public EstadoDeEnvioCambiado(Estado estado) {
        super("pedido.estadodeenviocambiaado");
        this.envioId = this.getEnvioId();
        this.estado = estado;
    }

    public EnvioId getEnvioId() {
        return envioId;
    }

    public Estado getEstado() {
        return estado;
    }
}
