package co.sofka.domain.dispositivo;

import co.com.sofka.domain.generic.EventChange;
import co.sofka.domain.dispositivo.entity.Celular;
import co.sofka.domain.dispositivo.entity.Promocion;
import co.sofka.domain.dispositivo.entity.Referencia;
import co.sofka.domain.dispositivo.events.DispositivoCreado;
import co.sofka.domain.dispositivo.events.PromocionAgregada;
import co.sofka.domain.dispositivo.events.ReferenciaAgregada;

public class DispositivoChange extends EventChange {

    public DispositivoChange(Dispositivo dispositivo){

        apply((DispositivoCreado event) ->{
            dispositivo.celularId = event.getCelularId();
        });

        /*apply((AlmacenamientoCelularActualizado event) ->{
            dispositivo.celular.cambiarAlmacenamiento(event.getEspecificaciones());
        });*/

        apply((PromocionAgregada event) ->{
            dispositivo.promocion = new Promocion(event.getPromocionId(),event.getDescuento());
        });

        apply((ReferenciaAgregada event) ->{
            dispositivo.referencia = new Referencia(event.getReferenciaId());
        });
    }
}
