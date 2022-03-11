package co.sofka.domain.carrito;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.carrito.entity.Compra;
import co.sofka.domain.carrito.entity.Articulo;
import co.sofka.domain.carrito.entity.value.Cantidad;
import co.sofka.domain.carrito.entity.value.CompraId;
import co.sofka.domain.carrito.entity.value.DetallesDeCompra;
import co.sofka.domain.carrito.events.*;
import co.sofka.domain.carrito.value.CarritoId;
import co.sofka.domain.carrito.value.Catalogo;
import co.sofka.domain.dispositivo.value.DispositivoId;
import co.sofka.domain.pedido.value.PedidoId;

import java.util.List;
import java.util.Objects;

public class Carrito extends AggregateEvent<CarritoId> {
    protected PedidoId pedidoId;
    protected DispositivoId dispositivoId;
    protected Compra compra;
    protected Catalogo catalogo;
    protected Articulo articulo;

    public Carrito(CarritoId entityId) {
        super(entityId);
        subscribe(new CarritoChange(this));
    }

    public Carrito(CarritoId entityId, Catalogo catalogo) {
        super(entityId);
        appendChange(new CarritoCreado(catalogo)).apply();
    }

    //Método para acceder a un carrito ya creado
    public static Carrito from(CarritoId carritoId, List<DomainEvent> events){
        var carrito = new Carrito(carritoId);
        events.forEach(carrito::applyEvent);
        return carrito;
    }

    //Comportamientos
    public void generarCompra(CompraId compraId, DetallesDeCompra detallesDeCompra){
        Objects.requireNonNull(compraId);
        Objects.requireNonNull(detallesDeCompra);
        appendChange(new CompraGenerada(compraId, detallesDeCompra)).apply();
    }

    public void cambiarCantidadArticulo(Cantidad cantidad){
        appendChange(new CantidadArticuloCambiada(cantidad)).apply();
    }

    public void agregarPedido(PedidoId pedidoId){
        appendChange(new PedidoAgregado(pedidoId)).apply();
    }

    public void agregarDispositivo(DispositivoId dispositivoId){
        appendChange(new DispositivoAgregado(dispositivoId)).apply();
    }



    public PedidoId pedidoId() {
        return pedidoId;
    }

    public DispositivoId dispositivoId() {
        return dispositivoId;
    }

    public Compra compra() {
        return compra;
    }

    public Catalogo catalogo() {
        return catalogo;
    }

    public Articulo articulo() {
        return articulo;
    }
}
