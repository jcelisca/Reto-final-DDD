package co.sofka.domain.carrito.entity.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DetallesDeCompra implements ValueObject<String> {
    private final String value;

    public DetallesDeCompra(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.length() < 10){
            throw new IllegalArgumentException("Los detales deben contener mas de 10 caracteres");
        }
    }

    public String value(){
        return value;
    }
}
