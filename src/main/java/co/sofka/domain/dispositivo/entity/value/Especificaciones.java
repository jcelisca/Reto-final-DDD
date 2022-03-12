package co.sofka.domain.dispositivo.entity.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especificaciones implements ValueObject<Especificaciones.Props> {
    private final String ram;
    private final String almacenamiento;
    private final String camara;

    public Especificaciones(String ram, String almacenamiento, String camara) {
        this.ram = Objects.requireNonNull(ram);
        this.almacenamiento = Objects.requireNonNull(almacenamiento);
        this.camara = camara;
    }

    //comportamiento
    public Especificaciones cambiarAlmacenamiento(String almacenamiento){
        return new Especificaciones(ram,almacenamiento, camara);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String ram() {
                return ram;
            }

            @Override
            public String almacenamiento() {
                return almacenamiento;
            }

            @Override
            public String camara() {
                return camara;
            }
        };
    }

    public interface Props{
        String ram();
        String almacenamiento();
        String camara();
    }
}
