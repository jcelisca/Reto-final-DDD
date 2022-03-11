package co.sofka.domain.pedido.entity.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;

public class Fecha implements ValueObject<Date> {
    private final Date value;

    public Fecha(Date value) {
        this.value = value;
    }

    public Fecha() {
        this(new Date());
    }

    @Override
    public Date value() {
        return value;
    }
}
