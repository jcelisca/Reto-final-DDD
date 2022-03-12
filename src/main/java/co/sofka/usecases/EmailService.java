package co.sofka.usecases;

import co.sofka.domain.pedido.entity.value.ClienteId;

public interface EmailService {
    boolean enviarEmailAlCliente(ClienteId clienteId, String mensaje);

}
