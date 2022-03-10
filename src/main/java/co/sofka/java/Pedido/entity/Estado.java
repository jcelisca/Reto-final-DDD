package co.sofka.java.Pedido.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.java.Pedido.entity.value.Entregado;
import co.sofka.java.Pedido.entity.value.EstadoId;

import java.util.Objects;

public class Estado extends Entity<EstadoId> {
    private Entregado entregado;

    public Estado(EstadoId entityId, Entregado entregado) {
        super(entityId);
        this.entregado = entregado;
    }

    public void cambiarEstadoEntregado(Entregado entregado){
        this.entregado = Objects.requireNonNull(entregado);
    }

    public Entregado Entregado() {
        return entregado;
    }
}
