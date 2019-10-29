package repositorio;

import modelo.Piloto;

public interface ICrearPilotoRepo {
    boolean guardar(Piloto pilotoNuevo);

    Piloto findByDNI(String pDNI);
}
