package co.sofka.java.Pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.java.Pedido.entity.value.Entregado;
import co.sofka.java.Pedido.entity.value.EstadoId;

public class Estado extends Entity<EstadoId> {
    private Entregado entregado;

    public Estado(EstadoId entityId, Entregado entregado) {
        super(entityId);
        this.entregado = new Entregado(Entregado.State.NO_ENTREGADO);
    }

    public void cambiarEstadoEntregado(Entregado entregado){
        this.entregado = new Entregado(Entregado.State.ENTREGADO);
    }

    public Entregado Entregado() {
        return entregado;
    }
}
