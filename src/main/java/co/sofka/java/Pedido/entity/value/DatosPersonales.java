package co.sofka.java.Pedido.entity.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosPersonales implements ValueObject<DatosPersonales.Props> {
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String celular;

    public DatosPersonales(String nombre, String apellido, String email, String celular) {
        this.nombre = Objects.requireNonNull(nombre);
        if(this.nombre.length() < 3){
            throw new IllegalArgumentException("El nombre debe tener mas de 3 letras");
        }
        this.apellido = apellido;
        this.email = Objects.requireNonNull(email);
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new IllegalArgumentException("El email no es válido");
        }
        this.celular = celular;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String apellido() {
                return apellido;
            }

            @Override
            public String email() {
                return email;
            }

            @Override
            public String celular() {
                return celular;
            }
        };
    }

    public interface Props{
        String nombre();
        String apellido();
        String email();
        String celular();
    }
}
