package co.sofka.java.Pedido.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MedioDePago implements ValueObject<String> {
    private final String value;

    public MedioDePago(String medioDePago) {
        this.value = Objects.requireNonNull(medioDePago);
    }

    public String value(){
        return value;
    }

}
