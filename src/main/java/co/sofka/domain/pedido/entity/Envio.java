package co.sofka.domain.pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.domain.pedido.entity.value.Estado;
import co.sofka.domain.pedido.entity.value.EnvioId;

public class Envio extends Entity<EnvioId> {
    private Estado estado;

    public Envio(EnvioId entityId) {
        super(entityId);
        this.estado = new Estado(Estado.State.NO_ENTREGADO);
    }

    public void cambiarEstadoEntregado(){
        this.estado = new Estado(Estado.State.ENTREGADO);
    }

    public Estado estado() {
        return estado;
    }
}
