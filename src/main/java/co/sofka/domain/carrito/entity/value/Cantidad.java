package co.sofka.domain.carrito.entity.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<Integer> {
    private final Integer value;

    public Cantidad(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value <= 0){
            throw new IllegalArgumentException("La cantidad mínima es 1");
        }
    }
     public Integer value(){
        return value;
     }
}
