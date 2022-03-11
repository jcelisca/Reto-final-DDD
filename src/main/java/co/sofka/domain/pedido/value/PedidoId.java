package co.sofka.domain.pedido.value;

import co.com.sofka.domain.generic.Identity;

public class PedidoId extends Identity {
    private PedidoId(String valor){
        super(valor);
    }

    public PedidoId () {};

    public static PedidoId of(String valor) {
        return new PedidoId(valor);
    }
}
