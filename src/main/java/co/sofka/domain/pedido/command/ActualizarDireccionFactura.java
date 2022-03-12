package co.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.pedido.entity.value.Direccion;
import co.sofka.domain.pedido.entity.value.FacturaId;
import co.sofka.domain.pedido.entity.value.Fecha;
import co.sofka.domain.pedido.value.PedidoId;

public class ActualizarDireccionFactura extends Command {
    private final PedidoId pedidoId;
    private final Direccion direccion;

    public ActualizarDireccionFactura(PedidoId pedidoId, Direccion direccion) {
        this.pedidoId = pedidoId;
        this.direccion = direccion;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
