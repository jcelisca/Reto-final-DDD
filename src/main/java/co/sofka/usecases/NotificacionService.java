package co.sofka.usecases;

import co.sofka.domain.carrito.entity.value.CompraId;

public interface NotificacionService {
    boolean enviarNotificacionContabilidad(CompraId compraId, String mensaje);
}
