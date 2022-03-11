package co.sofka.domain.carrito.command;

import co.com.sofka.domain.generic.Command;
import co.sofka.domain.carrito.value.CarritoId;
import co.sofka.domain.dispositivo.value.DispositivoId;

public class AgregarDispositivo extends Command {
    private final CarritoId carritoId;
    private final DispositivoId dispositivoId;

    public AgregarDispositivo(CarritoId carritoId, DispositivoId dispositivoId) {
        this.carritoId = carritoId;
        this.dispositivoId = dispositivoId;
    }

    public DispositivoId getDispositivoId() {
        return dispositivoId;
    }

    public CarritoId getCarritoId() {
        return carritoId;
    }
}
