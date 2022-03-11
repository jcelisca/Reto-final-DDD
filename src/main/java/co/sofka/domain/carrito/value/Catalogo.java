package co.sofka.domain.carrito.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.List;

public class Catalogo implements ValueObject<List<String>> {
    public final List<String> value;

    public Catalogo(List<String> value) {
        this.value = value;
    }

    public List<String> value(){
        return value;
    }
}
