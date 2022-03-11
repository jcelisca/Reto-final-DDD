package co.sofka.domain.carrito.entity.value;

import co.com.sofka.domain.generic.Identity;

public class ArticuloId extends Identity {
    private ArticuloId(String valor){
        super(valor);
    }

    public ArticuloId() {};

    public static ArticuloId of(String valor) {
        return new ArticuloId(valor);
    }
}
