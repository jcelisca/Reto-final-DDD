package co.sofka.java.Pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.sofka.java.Pedido.entity.Estado;
import co.sofka.java.Pedido.entity.Factura;
import co.sofka.java.Pedido.entity.value.*;
import co.sofka.java.Pedido.events.*;
import co.sofka.java.Pedido.value.MedioDePago;
import co.sofka.java.Pedido.value.PedidoId;

import java.util.Objects;

public class Pedido extends AggregateEvent<PedidoId> {
    private ClienteId clienteId;
    private Estado estado;
    private Factura factura;
    private MedioDePago medioDePago;

    private Pedido(PedidoId entityId){
        super(entityId);
        subscribe(new PedidoChange(this));
    }

    public Pedido(PedidoId entityId, Estado estado) {
        super(entityId);
        appendChange(new PedidoCreado(estado)).apply();
    }

    public void generarFactura (FacturaId facturaId, Fecha fecha, Direccion direccion){
        Objects.requireNonNull(facturaId);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(direccion);
        appendChange(new FacturaGenerada(facturaId, fecha, direccion)).apply();
    }

    public void actualizarDireccionFactura (Direccion direccion){
        appendChange(new DireccionFacturaActualizada(direccion)).apply();
    }

    public void agregarCliente(ClienteId clienteId, DatosPersonales datosPersonales){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(datosPersonales);
        appendChange(new ClienteAgregado(clienteId, datosPersonales)).apply();
    }

    public void actualizarDatosPersonalesCliente(DatosPersonales datosPersonales){
        appendChange(new DatosClienteActualizado(datosPersonales)).apply();
    }

    public void agregarMedioDePago(MedioDePago medioDePago){
        Objects.requireNonNull(medioDePago);
        appendChange(new MedioDePagoAgregado(medioDePago)).apply();
    }

    public ClienteId ClienteId() {
        return clienteId;
    }

    public Estado Estado() {
        return estado;
    }

    public Factura Factura() {
        return factura;
    }

    public MedioDePago MedioDePago() {
        return medioDePago;
    }
}
