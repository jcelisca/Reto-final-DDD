package co.sofka.java.Pedido;

import co.com.sofka.domain.generic.EventChange;
import co.sofka.java.Pedido.entity.Factura;
import co.sofka.java.Pedido.events.*;

public class PedidoChange extends EventChange {

    public PedidoChange (Pedido pedido){

        apply((PedidoCreado event) ->{
            pedido.estado = event.getEstado();
        });

        apply((FacturaGenerada event) -> {
            pedido.factura = new Factura(event.getFacturaId(), event.getFecha(), event.getDireccion());
        });

        apply((ClienteAgregado event) ->{
            pedido.clienteId = event.getClienteId();
        });

        apply((DireccionFacturaActualizada event) ->{
            pedido.actualizarDireccionFactura(event.getDireccion());
        });

        apply((DatosClienteActualizado event) ->{
            pedido.actualizarDatosPersonalesCliente(event.getDatosPersonales());
        });

        apply((MedioDePagoAgregado event) ->{
            pedido.medioDePago = event.getMedioDePago();
        });
    }
}
