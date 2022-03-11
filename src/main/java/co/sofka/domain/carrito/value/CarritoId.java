package co.sofka.domain.carrito.value;

import co.com.sofka.domain.generic.Identity;

public class CarritoId extends Identity {
    private CarritoId(String valor){
        super(valor);
    }

    public CarritoId () {};

    public static CarritoId of(String valor) {
        return new CarritoId(valor);
    }
}
