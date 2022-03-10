package co.sofka.java.Pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.java.Pedido.entity.value.ClienteId;
import co.sofka.java.Pedido.entity.value.DatosPersonales;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {
    private DatosPersonales datosPersonales;

    public Cliente(ClienteId entityId, DatosPersonales datosPersonales) {
        super(entityId);
        this.datosPersonales = datosPersonales;
    }

    //Comportamiento
    public void actualizarDatosPersonales (DatosPersonales datosPersonales){
        this.datosPersonales = Objects.requireNonNull(datosPersonales);
    }

    public DatosPersonales DatosPersonales() {
        return datosPersonales;
    }
}
