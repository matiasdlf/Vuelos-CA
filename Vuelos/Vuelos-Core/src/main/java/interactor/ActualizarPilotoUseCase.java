package interactor;

import excepciones.PilotoExisteException;
import modelo.Piloto;
import repositorio.IActualizarPilotoRepo;

public class ActualizarPilotoUseCase {
    private IActualizarPilotoRepo actualizarPilotoRepo;

    public ActualizarPilotoUseCase(IActualizarPilotoRepo actualizarPilotoRepo) {

        this.actualizarPilotoRepo = actualizarPilotoRepo;
    }

    public boolean actualizarPiloto(Piloto pilotoDatosNuevos) throws PilotoExisteException {
        Piloto pilotoAModificar = actualizarPilotoRepo.findByDNI(pilotoDatosNuevos.getDNI());
        if (pilotoAModificar == null) {
            return this.actualizarPilotoRepo.guardar(pilotoDatosNuevos);
        } else if (pilotoAModificar.getIdPiloto() != pilotoDatosNuevos.getIdPiloto()) {
            throw new PilotoExisteException();
        } else {
            if (pilotoAModificar.getDNI().equals(pilotoDatosNuevos.getDNI())) {
                return this.actualizarPilotoRepo.guardar(pilotoDatosNuevos);
            }
        }
        return false;
    }

}
