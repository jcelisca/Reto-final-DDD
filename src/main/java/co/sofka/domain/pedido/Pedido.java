package co.sofka.domain.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.pedido.entity.Cliente;
import co.sofka.domain.pedido.entity.Factura;
import co.sofka.domain.pedido.entity.value.*;
import co.sofka.domain.pedido.events.*;
import co.sofka.domain.pedido.value.MedioDePago;
import co.sofka.domain.pedido.value.PedidoId;

import java.util.List;
import java.util.Objects;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Cliente cliente;
    protected EnvioId envioId;
    protected Factura factura;
    protected MedioDePago medioDePago;

    private Pedido(PedidoId entityId){
        super(entityId);
        subscribe(new PedidoChange(this));
    }

    public Pedido(PedidoId entityId, EnvioId envioId) {
        super(entityId);
        appendChange(new PedidoCreado(envioId)).apply();
    }

    //Método para acceder a un pedido ya creado
    public static Pedido from(PedidoId pedidoId, List<DomainEvent> events){
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    //Comportamientos del agregado
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

    public void agregarMedioDePago(MedioDePago medioDePago){
        Objects.requireNonNull(medioDePago);
        appendChange(new MedioDePagoAgregado(medioDePago)).apply();
    }


    public Cliente cliente() {
        return cliente;
    }

    public EnvioId envioId() {
        return envioId;
    }

    public Factura factura() {
        return factura;
    }

    public MedioDePago medioDePago() {
        return medioDePago;
    }
}
