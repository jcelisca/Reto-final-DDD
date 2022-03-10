package co.sofka.java.Pedido;

import co.com.sofka.domain.generic.EventChange;
import co.sofka.java.Pedido.events.PedidoCreado;

public class PedidoChange extends EventChange {
    /*public PedidoChange (Pedido pedido){
        apply((PedidoCreado event) ->{
            pedido.estado = event.getEstado();
        });
    }*/
}
