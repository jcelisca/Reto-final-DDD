package co.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.pedido.value.MedioDePago;
import co.sofka.domain.pedido.value.PedidoId;

public class AgregarMedioDePago extends Command {
    private final PedidoId pedidoId;
    private final MedioDePago medioDePago;

    public AgregarMedioDePago(PedidoId pedidoId, MedioDePago medioDePago) {
        this.pedidoId = pedidoId;
        this.medioDePago = medioDePago;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }
}
