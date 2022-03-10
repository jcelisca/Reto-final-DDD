package co.sofka.java.Pedido.entity.value;

import co.com.sofka.domain.generic.Identity;
import co.sofka.java.Pedido.value.PedidoId;

public class EstadoId extends Identity {

    private EstadoId(String valor){
        super(valor);
    }

    public EstadoId () {};

    public static EstadoId of(String valor) {
        return new EstadoId(valor);
    }
}
