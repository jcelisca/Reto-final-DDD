package co.sofka.java.Pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.java.Pedido.entity.value.DatosPersonales;

public class DatosClienteActualizado extends DomainEvent {
    private final DatosPersonales datosPersonales;

    public DatosClienteActualizado(DatosPersonales datosPersonales) {
        super("pedido.datosclienteactualizado");
        this.datosPersonales = datosPersonales;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
