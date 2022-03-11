package co.sofka.java.Carrito.entity.value;

import co.com.sofka.domain.generic.Identity;

public class DisponibilidadId extends Identity {
    private DisponibilidadId(String valor){
        super(valor);
    }

    public DisponibilidadId () {};

    public static DisponibilidadId of(String valor) {
        return new DisponibilidadId(valor);
    }
}
