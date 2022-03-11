package co.sofka.java.Pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.java.Pedido.entity.value.DatosPersonales;
import co.sofka.java.Pedido.value.PedidoId;

public class ActualizarDatosPersonalesCliente extends Command {
    private final PedidoId pedidoId;
    private final DatosPersonales datosPersonales;

    public ActualizarDatosPersonalesCliente(PedidoId pedidoId, DatosPersonales datosPersonales) {
        this.pedidoId = pedidoId;
        this.datosPersonales = datosPersonales;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
