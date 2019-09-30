package repositorio;

import modelo.Piloto;

import java.util.Collection;

public interface IBuscarPilotosPorNombreRepo {
    Collection<Piloto> buscarPilotosPorNombre(String nombrePiloto);
}
