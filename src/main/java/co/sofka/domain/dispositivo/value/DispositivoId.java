package co.sofka.domain.dispositivo.value;

import co.com.sofka.domain.generic.Identity;

public class DispositivoId extends Identity {
    private DispositivoId(String valor){
        super(valor);
    }

    public DispositivoId() {};

    public static DispositivoId of(String valor) {
        return new DispositivoId(valor);
    }
}
