package co.sofka.domain.dispositivo.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.dispositivo.entity.value.CelularId;
import co.sofka.domain.dispositivo.value.DispositivoId;

public class CrearDispositivo extends Command {
    private final DispositivoId dispositivoId;
    private final CelularId celularId;

    public CrearDispositivo(DispositivoId dispositivoId, CelularId celularId) {
        this.dispositivoId = dispositivoId;
        this.celularId = celularId;
    }

    public DispositivoId getDispositivoId() {
        return dispositivoId;
    }

    public CelularId getCelularId() {
        return celularId;
    }
}
