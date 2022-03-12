package co.sofka.domain.dispositivo.entity.value;

import co.com.sofka.domain.generic.Identity;

public class CelularId extends Identity {
    private CelularId (String valor){
        super(valor);
    }

    public CelularId () {};

    public static CelularId of(String valor) {
        return new CelularId(valor);
    }
}
