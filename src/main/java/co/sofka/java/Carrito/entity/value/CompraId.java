package co.sofka.java.Carrito.entity.value;

import co.com.sofka.domain.generic.Identity;

public class CompraId extends Identity {
    private CompraId(String valor){
        super(valor);
    }

    public CompraId () {};

    public static CompraId of(String valor) {
        return new CompraId(valor);
    }
}
