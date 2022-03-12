package co.sofka.domain.dispositivo.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.dispositivo.entity.value.Descuento;
import co.sofka.domain.dispositivo.entity.value.PromocionId;
import co.sofka.domain.dispositivo.value.DispositivoId;

public class AgregarPromocion extends Command {
    private final DispositivoId dispositivoId;
    private final PromocionId promocionId;
    private final Descuento descuento;

    public AgregarPromocion(DispositivoId dispositivoId, PromocionId promocionId, Descuento descuento) {
        this.dispositivoId = dispositivoId;
        this.promocionId = promocionId;
        this.descuento = descuento;
    }

    public DispositivoId getDispositivoId() {
        return dispositivoId;
    }

    public PromocionId getPromocionId() {
        return promocionId;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
