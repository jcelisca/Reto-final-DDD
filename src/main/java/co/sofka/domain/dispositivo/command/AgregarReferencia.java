package co.sofka.domain.dispositivo.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.dispositivo.entity.Referencia;
import co.sofka.domain.dispositivo.entity.value.Audifonos;
import co.sofka.domain.dispositivo.entity.value.Cargador;
import co.sofka.domain.dispositivo.value.DispositivoId;

public class AgregarReferencia extends Command {
    private final DispositivoId dispositivoId;
    private final Referencia referencia;
    private final Audifonos audifonos;
    private final Cargador cargador;

    public AgregarReferencia(DispositivoId dispositivoId, Referencia referencia, Audifonos audifonos, Cargador cargador) {
        this.dispositivoId = dispositivoId;
        this.referencia = referencia;
        this.audifonos = audifonos;
        this.cargador = cargador;
    }

    public DispositivoId getDispositivoId() {
        return dispositivoId;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public Audifonos getAudifonos() {
        return audifonos;
    }

    public Cargador getCargador() {
        return cargador;
    }
}
