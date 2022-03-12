package co.sofka.domain.dispositivo.entity;

import co.com.sofka.domain.generic.Entity;
import co.sofka.domain.dispositivo.entity.value.CelularId;
import co.sofka.domain.dispositivo.entity.value.Especificaciones;
import co.sofka.domain.dispositivo.entity.value.Marca;
import co.sofka.domain.dispositivo.entity.value.Precio;

import java.util.Objects;

public class Celular extends Entity<CelularId> {
    private Especificaciones especificaciones;
    private Marca marca;
    private Precio precio;

    public Celular(CelularId entityId, Especificaciones especificaciones, Marca marca, Precio precio) {
        super(entityId);
        this.especificaciones = especificaciones;
        this.marca = marca;
        this.precio = precio;
    }

    //Comportamientos
    public void cambiarAlmacenamiento(Especificaciones especificaciones){
        this.especificaciones = Objects.requireNonNull(especificaciones);
    }

    public void actualizarMarca(Marca marca){
        this.marca = Objects.requireNonNull(marca);
    }

    public void actualizarPrecio(Precio precio){
        this.precio = Objects.requireNonNull(precio);
    }


    public Especificaciones especificaciones() {
        return especificaciones;
    }

    public Marca marca() {
        return marca;
    }

    public Precio precio() {
        return precio;
    }
}
