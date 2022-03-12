package co.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.pedido.entity.value.EnvioId;
import co.sofka.domain.pedido.entity.value.Estado;

public class CambiarEstadoDeEnvio extends Command {
    private final EnvioId envioId;
    private final Estado estado;

    public CambiarEstadoDeEnvio(Estado estado) {
        this.envioId = this.getEnvioId();
        this.estado = estado;
    }

    public EnvioId getEnvioId() {
        return envioId;
    }

    public Estado getEstado() {
        return estado;
    }
}
