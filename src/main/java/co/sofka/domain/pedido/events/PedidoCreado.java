package co.sofka.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.entity.Envio;
import co.sofka.domain.pedido.entity.value.EnvioId;

public class PedidoCreado extends DomainEvent {
    private final Envio envio;

    public PedidoCreado(EnvioId envioId) {
        super("pedido.pedidocreado");
        this.envio = new Envio(envioId);
    }

    public Envio getEnvio() {
        return envio;
    }
}
