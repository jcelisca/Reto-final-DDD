package co.sofka.domain.dispositivo.entity.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Double> {
    private final Double value;

    public Precio(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value <= 0.0){
            throw new IllegalArgumentException("El valor no puede ser menor que cero");
        }
    }
    public Double value(){
        return value;
    }
}
