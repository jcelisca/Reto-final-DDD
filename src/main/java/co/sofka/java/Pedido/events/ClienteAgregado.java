package co.sofka.java.Pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.java.Pedido.entity.value.ClienteId;
import co.sofka.java.Pedido.entity.value.DatosPersonales;

public class ClienteAgregado extends DomainEvent {
    private final ClienteId clienteId;
    private final DatosPersonales datosPersonales;

    public ClienteAgregado(ClienteId clienteId, DatosPersonales datosPersonales) {
        super("pedido.clienteactualizado");
        this.clienteId = clienteId;
        this.datosPersonales = datosPersonales;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
