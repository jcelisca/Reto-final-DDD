package co.sofka.java.Pedido.entity.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<Direccion.Props> {
    private final String ciudad;
    private final String direccionDomicilio;


    public Direccion(String ciudad, String direccionDomicilio) {
        this.ciudad = Objects.requireNonNull(ciudad);
        this.direccionDomicilio = Objects.requireNonNull(direccionDomicilio);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String ciudad() {
                return ciudad;
            }

            @Override
            public String direccionDomicilio() {
                return direccionDomicilio;
            }
        };
    }


    public interface Props{
        String ciudad();
        String direccionDomicilio();
    }
}
