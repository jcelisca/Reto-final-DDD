package co.sofka.domain.dispositivo.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.domain.dispositivo.entity.value.Audifonos;
import co.sofka.domain.dispositivo.entity.value.Cargador;
import co.sofka.domain.dispositivo.entity.value.ReferenciaId;

public class Referencia extends Entity<ReferenciaId> {
    private Audifonos audifonos;
    private Cargador cargador;

    public Referencia(ReferenciaId entityId) {
        super(entityId);
        this.audifonos = new Audifonos(Audifonos.State.NO_INCLUYE);
        this.cargador = new Cargador(Cargador.State.INCLUYE);
    }

    //comportamientos
    public void incluirAudifonos(){
        this.audifonos = new Audifonos(Audifonos.State.INCLUYE);
    }
    public void incluirCargador(){
        this.cargador = new Cargador(Cargador.State.NO_INCLUYE);
    }


    public Audifonos audifonos() {
        return audifonos;
    }

    public Cargador cargador() {
        return cargador;
    }
}
