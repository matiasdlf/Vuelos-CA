package interactor;

import excepciones.TipoPilotoExisteException;
import modelo.TipoPiloto;
import repositorio.ICrearTipoPilotoRepo;

public class CrearTipoPilotoUseCase {
    private ICrearTipoPilotoRepo crearTipoPilotoRepo;

    public CrearTipoPilotoUseCase(ICrearTipoPilotoRepo crearTipoPilotoRepo) {

        this.crearTipoPilotoRepo = crearTipoPilotoRepo;
    }

    public boolean crearTipoPiloto(TipoPiloto tipoPilotoCrear) throws TipoPilotoExisteException {
        if(crearTipoPilotoRepo.findByDenominacion(tipoPilotoCrear.getDenominacion())==null)
            return crearTipoPilotoRepo.guardar(tipoPilotoCrear);
        throw new TipoPilotoExisteException();
    }
}
