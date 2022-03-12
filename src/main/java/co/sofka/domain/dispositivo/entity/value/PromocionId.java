package co.sofka.domain.dispositivo.entity.value;

import co.com.sofka.domain.generic.Identity;

public class PromocionId extends Identity {
    private PromocionId(String valor){
        super(valor);
    }

    public PromocionId() {};

    public static PromocionId of(String valor) {
        return new PromocionId(valor);
    }
}
