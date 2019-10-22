package interactor;

import modelo.Piloto;
import repositorio.IBuscarPilotosPorNombreRepo;

import java.util.List;

public class BuscarPilotosPorNombreUseCase {
    private IBuscarPilotosPorNombreRepo buscarPilotosPorNombreRepo;

    public BuscarPilotosPorNombreUseCase(IBuscarPilotosPorNombreRepo buscarPilotosPorNombreRepo) {
        this.buscarPilotosPorNombreRepo = buscarPilotosPorNombreRepo;
    }

    public List<Piloto> buscarPilotosPorNombre(String nombrePiloto) {
       return (List<Piloto>) buscarPilotosPorNombreRepo.buscarPilotosPorNombre(nombrePiloto);

    }
}
