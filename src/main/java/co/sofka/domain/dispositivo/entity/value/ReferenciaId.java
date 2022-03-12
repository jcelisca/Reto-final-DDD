package co.sofka.domain.dispositivo.entity.value;

import co.com.sofka.domain.generic.Identity;

public class ReferenciaId extends Identity {
    private ReferenciaId(String valor){
        super(valor);
    }

    public ReferenciaId() {};

    public static ReferenciaId of(String valor) {
        return new ReferenciaId(valor);
    }
}
