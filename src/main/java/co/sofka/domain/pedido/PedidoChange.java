package co.sofka.domain.pedido;

import co.com.sofka.domain.generic.EventChange;
import co.sofka.domain.pedido.command.CambiarEstadoDeEnvio;
import co.sofka.domain.pedido.entity.Cliente;
import co.sofka.domain.pedido.entity.Factura;
import co.sofka.domain.pedido.events.*;

public class PedidoChange extends EventChange {

    public PedidoChange (Pedido pedido){

        apply((PedidoCreado event) ->{
            pedido.envioId = event.getEnvio().identity();
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

        apply((MedioDePagoAgregado event) ->{
            pedido.medioDePago = event.getMedioDePago();
        });

    }
}
