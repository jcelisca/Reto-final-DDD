package co.sofka.domain.pedido.entity.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;

public class Fecha implements ValueObject<LocalDate> {
    private final LocalDate value;

    public Fecha(LocalDate value) {
        this.value = value;
    }

    public Fecha() {
        this(LocalDate.now());
    }

    @Override
    public LocalDate value() {
        return value;
    }
}
