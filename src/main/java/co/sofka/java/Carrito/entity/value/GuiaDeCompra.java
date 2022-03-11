package co.sofka.java.Carrito.entity.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class GuiaDeCompra implements ValueObject<String> {
    private final String value;

    public GuiaDeCompra(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.length() < 5){
            throw new IllegalArgumentException("La guia debe contener más de 5 caracteres");
        }
    }

    public String value(){
        return value;
    }
}
