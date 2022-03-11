package co.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.pedido.entity.value.ClienteId;
import co.sofka.domain.pedido.entity.value.DatosPersonales;
import co.sofka.domain.pedido.value.PedidoId;

public class AgregarCliente extends Command {
    private final PedidoId pedidoId;
    private final ClienteId clienteId;
    private final DatosPersonales datosPersonales;

    public AgregarCliente(PedidoId pedidoId, ClienteId clienteId, DatosPersonales datosPersonales) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.datosPersonales = datosPersonales;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
