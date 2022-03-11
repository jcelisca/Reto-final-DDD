package co.sofka.domain.carrito;

import co.com.sofka.domain.generic.EventChange;
import co.sofka.domain.carrito.entity.Compra;
import co.sofka.domain.carrito.events.*;

public class CarritoChange extends EventChange {
    public CarritoChange(Carrito carrito){

        apply((CarritoCreado event) ->{
            carrito.catalogo = event.getCatalogo();
        });

        apply((CompraGenerada event) ->{
            carrito.compra = new Compra(event.getCompraId(),event.getDetallesDeCompra());
        });

        apply((CantidadArticuloCambiada event) ->{
            carrito.articulo.cambiarCantidad(event.getCantidad());
        });

        apply((PedidoAgregado event) ->{
            carrito.pedidoId = event.getPedidoId();
        });

        apply((DispositivoAgregado event) ->{
            carrito.dispositivoId = event.getDispositivoId();
        });
    }
}
