package co.sofka.domain.dispositivo.entity.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descuento implements ValueObject<Double> {
    private final Double value;

    public Descuento(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value <= 0.0){
            throw new IllegalArgumentException("El descuento debe ser mayor que cero");
        }
    }
    public Double value(){
        return value;
    }
}
