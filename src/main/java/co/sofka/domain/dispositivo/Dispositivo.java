package co.sofka.domain.dispositivo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.sofka.domain.dispositivo.entity.Promocion;
import co.sofka.domain.dispositivo.entity.Referencia;
import co.sofka.domain.dispositivo.entity.value.*;
import co.sofka.domain.dispositivo.events.AlmacenamientoCelularActualizado;
import co.sofka.domain.dispositivo.events.DispositivoCreado;
import co.sofka.domain.dispositivo.events.PromocionAgregada;
import co.sofka.domain.dispositivo.events.ReferenciaAgregada;
import co.sofka.domain.dispositivo.value.DispositivoId;

import java.util.List;
import java.util.Objects;

public class Dispositivo extends AggregateEvent<DispositivoId> {
    protected CelularId celularId;
    protected Referencia referencia;
    protected Promocion promocion;

    private Dispositivo(DispositivoId entityId){
        super(entityId);
        subscribe(new DispositivoChange(this));
    }

    public Dispositivo(DispositivoId entityId, CelularId celularId) {
        super(entityId);
        appendChange(new DispositivoCreado(celularId)).apply();
    }

    //Método para acceder a un pedido ya creado
    public static Dispositivo from(DispositivoId dispositivoId, List<DomainEvent> events){
        var dispositivo = new Dispositivo(dispositivoId);
        events.forEach(dispositivo::applyEvent);
        return dispositivo;
    }

    //comportamientos
    public void cambiarAlmacenamientoCelular(Especificaciones especificaciones){
        Objects.requireNonNull(especificaciones);
        appendChange(new AlmacenamientoCelularActualizado(especificaciones)).apply();
    }

    public void agregarReferencia(ReferenciaId referenciaId, Audifonos audifonos, Cargador cargador){
        Objects.requireNonNull(referenciaId);
        Objects.requireNonNull(audifonos);
        Objects.requireNonNull(cargador);
        appendChange(new ReferenciaAgregada(referenciaId, audifonos, cargador)).apply();
    }

    public void agregarPromocion(PromocionId promocionId, Descuento descuento){
        Objects.requireNonNull(promocionId);
        Objects.requireNonNull(descuento);
        appendChange(new PromocionAgregada(promocionId, descuento)).apply();
    }

    public CelularId celularId() {
        return celularId;
    }

    public Referencia referencia() {
        return referencia;
    }

    public Promocion promocion() {
        return promocion;
    }
}
