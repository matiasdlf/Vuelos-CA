package interactor;

import excepciones.PilotoExisteException;
import modelo.Piloto;
import repositorio.ICrearPilotoRepo;

public class CrearPilotoUseCase {
    private ICrearPilotoRepo crearPilotoRepo;

    public CrearPilotoUseCase(ICrearPilotoRepo crearPilotoRepo) {
        this.crearPilotoRepo = crearPilotoRepo;
    }

    public boolean crearPiloto(Piloto pilotoNuevo) throws PilotoExisteException {
        if (!existePiloto(pilotoNuevo)) {
            return this.crearPilotoRepo.guardar(pilotoNuevo);
        }
        throw new PilotoExisteException();
    }

    private boolean existePiloto(Piloto pilotoNuevo) {
        return crearPilotoRepo.findByDNI(pilotoNuevo.getDNI())!=null;
    }
}
