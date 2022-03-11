package co.sofka.java.Pedido;

import co.com.sofka.domain.generic.EventChange;
import co.sofka.java.Pedido.entity.Cliente;
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
            pedido.cliente = new Cliente(event.getClienteId(), event.getDatosPersonales());
        });

        apply((DireccionFacturaActualizada event) ->{
            pedido.factura.actualizarDireccion(event.getDireccion());
        });

        apply((DatosClienteActualizado event) ->{
            pedido.cliente.actualizarDatosPersonales(event.getDatosPersonales());
        });

        apply((MedioDePagoAgregado event) ->{
            pedido.medioDePago = event.getMedioDePago();
        });
    }
}
