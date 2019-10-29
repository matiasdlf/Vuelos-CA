package repositorio;

import modelo.Piloto;

public interface IActualizarPilotoRepo {


    boolean actualizar(Piloto pilotoDatosNuevos);

    Piloto findByDNI(String dni);
}
