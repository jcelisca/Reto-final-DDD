package co.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.pedido.entity.value.Direccion;
import co.sofka.domain.pedido.entity.value.FacturaId;
import co.sofka.domain.pedido.entity.value.Fecha;
import co.sofka.domain.pedido.value.PedidoId;

public class GenerarFactura extends Command {
    private final PedidoId pedidoId;
    private final FacturaId facturaId;
    private final Fecha fecha;
    private final Direccion direccion;

    public GenerarFactura(PedidoId pedidoId, FacturaId facturaId, Fecha fecha, Direccion direccion) {
        this.pedidoId = pedidoId;
        this.facturaId = facturaId;
        this.fecha = fecha;
        this.direccion = direccion;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
