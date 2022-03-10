package co.sofka.java.Pedido.entity.value;

import co.com.sofka.domain.generic.ValueObject;

public class DatosPersonales implements ValueObject<DatosPersonales.Props> {
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String celular;

    public DatosPersonales(String nombre, String apellido, String email, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
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
