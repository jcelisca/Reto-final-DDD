package co.sofka.domain.carrito.entity.value;

import co.com.sofka.domain.generic.ValueObject;

public class EnStock implements ValueObject<EnStock.State> {
    private final State value;

    public EnStock(State value) {
        this.value = value;
    }

    @Override
    public State value() {
        return value;
    }

    public enum State {
        DSPONIBLE, NO_DISPONIBLE
    }
}
