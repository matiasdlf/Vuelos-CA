package repositorio;

import modelo.Piloto;

public interface IActualizarPilotoRepo {


    boolean guardar(Piloto pilotoDatosNuevos);

    Piloto findByDNI(String dni);
}
