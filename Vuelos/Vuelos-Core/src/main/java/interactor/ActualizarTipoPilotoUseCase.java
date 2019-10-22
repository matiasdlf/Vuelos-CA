package interactor;

import modelo.TipoPiloto;
import repositorio.IActualizarTipoPilotoRepo;

import java.util.ArrayList;
import java.util.Collection;

public class ActualizarTipoPilotoUseCase {

    IActualizarTipoPilotoRepo actualizarTipoPilotoRepo;

    public ActualizarTipoPilotoUseCase(IActualizarTipoPilotoRepo actualizarTipoPilotoRepo) {
        this.actualizarTipoPilotoRepo = actualizarTipoPilotoRepo;
    }

    public boolean actualizarTipoPiloto(TipoPiloto tipoPilotoDatosNuevos){
        TipoPiloto tipoPilotoAModificar = actualizarTipoPilotoRepo.findByIdTipoPiloto(tipoPilotoDatosNuevos.getIdTipoPiloto());
        if (tipoPilotoAModificar!=null)
            {
                Collection<TipoPiloto> tipoPilotos = actualizarTipoPilotoRepo.findTipoPilotosPorDenominacion(tipoPilotoDatosNuevos.getDenominacion());
                if (tipoPilotos.size()==0 ) {
                    return this.actualizarTipoPilotoRepo.actualizar(tipoPilotoDatosNuevos);
                }
        }
        return false;
    }

}
