package co.sofka.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.domain.pedido.entity.value.ClienteId;
import co.sofka.domain.pedido.entity.value.DatosPersonales;

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

    public void ACtualizarCelular(String celular){
        this.datosPersonales = datosPersonales.cambiarTelefono(celular);
    }

    public DatosPersonales datosPersonales() {
        return datosPersonales;
    }
}
