package co.sofka.domain.dispositivo.entity.value;

import co.com.sofka.domain.generic.ValueObject;

public class Cargador implements ValueObject<Cargador.State> {
    private final State value;

    public Cargador(State value) {
        this.value = value;
    }

    @Override
    public State value() {
        return value;
    }

    public enum State {
        INCLUYE, NO_INCLUYE
    }
}
