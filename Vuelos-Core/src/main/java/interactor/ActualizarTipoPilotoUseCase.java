package interactor;

import excepciones.TipoPilotoExisteException;
import input.IActualizarTipoPilotoInput;
import modelo.TipoPiloto;
import repositorio.IActualizarTipoPilotoRepo;

public class ActualizarTipoPilotoUseCase implements IActualizarTipoPilotoInput {

    private IActualizarTipoPilotoRepo actualizarTipoPilotoRepo;

    public ActualizarTipoPilotoUseCase(IActualizarTipoPilotoRepo actualizarTipoPilotoRepo) {
        this.actualizarTipoPilotoRepo = actualizarTipoPilotoRepo;
    }

    @Override
    public boolean actualizarTipoPiloto(TipoPiloto tipoPilotoDatosNuevos) throws TipoPilotoExisteException {
        TipoPiloto tipoPilotoAModificar = actualizarTipoPilotoRepo.findByDenominacion(tipoPilotoDatosNuevos.getDenominacion());
        if (tipoPilotoAModificar == null) {
            return this.actualizarTipoPilotoRepo.actualizar(tipoPilotoDatosNuevos);
        } else if (tipoPilotoAModificar.getIdTipoPiloto() != tipoPilotoDatosNuevos.getIdTipoPiloto()) {
            throw new TipoPilotoExisteException();
        } else {
            return this.actualizarTipoPilotoRepo.actualizar(tipoPilotoDatosNuevos);
        }
    }

}
