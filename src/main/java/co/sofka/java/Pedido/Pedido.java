package co.sofka.java.Pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.java.Pedido.entity.Cliente;
import co.sofka.java.Pedido.entity.Estado;
import co.sofka.java.Pedido.entity.Factura;
import co.sofka.java.Pedido.entity.value.*;
import co.sofka.java.Pedido.events.*;
import co.sofka.java.Pedido.value.MedioDePago;
import co.sofka.java.Pedido.value.PedidoId;

import java.util.List;
import java.util.Objects;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Cliente cliente;
    protected Estado estado;
    protected Factura factura;
    protected MedioDePago medioDePago;

    private Pedido(PedidoId entityId){
        super(entityId);
        subscribe(new PedidoChange(this));
    }

    public Pedido(PedidoId entityId, Estado estado) {
        super(entityId);
        appendChange(new PedidoCreado(estado)).apply();
    }

    //Método para acceder a un pedido ya creado
    public static Pedido from(PedidoId pedidoId, List<DomainEvent> events){
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
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


    public Cliente Cliente() {
        return cliente;
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
