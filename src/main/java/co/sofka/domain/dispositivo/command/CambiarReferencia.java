package co.sofka.domain.dispositivo.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.dispositivo.entity.value.Audifonos;
import co.sofka.domain.dispositivo.entity.value.Cargador;
import co.sofka.domain.dispositivo.entity.value.ReferenciaId;
import co.sofka.domain.dispositivo.value.DispositivoId;

public class CambiarReferencia extends Command {
    private final DispositivoId dispositivoId;
    private final ReferenciaId referenciaId;
    private final Audifonos audifonos;
    private final Cargador cargador;

    public CambiarReferencia(DispositivoId dispositivoId, ReferenciaId referenciaId, Audifonos audifonos, Cargador cargador) {
        this.dispositivoId = dispositivoId;
        this.referenciaId = referenciaId;
        this.audifonos = audifonos;
        this.cargador = cargador;
    }

    public DispositivoId getDispositivoId() {
        return dispositivoId;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public Audifonos getAudifonos() {
        return audifonos;
    }

    public Cargador getCargador() {
        return cargador;
    }
}
