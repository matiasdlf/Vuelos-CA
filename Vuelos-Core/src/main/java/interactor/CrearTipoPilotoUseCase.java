package interactor;

import excepciones.TipoPilotoExisteException;
import input.ICrearTipoPilotoInput;
import modelo.TipoPiloto;
import repositorio.ICrearTipoPilotoRepo;

public class CrearTipoPilotoUseCase implements ICrearTipoPilotoInput {
    private ICrearTipoPilotoRepo crearTipoPilotoRepo;

    public CrearTipoPilotoUseCase(ICrearTipoPilotoRepo crearTipoPilotoRepo) {

        this.crearTipoPilotoRepo = crearTipoPilotoRepo;
    }

    @Override
    public boolean crearTipoPiloto(TipoPiloto tipoPilotoCrear) throws TipoPilotoExisteException {
        if(crearTipoPilotoRepo.findByDenominacion(tipoPilotoCrear.getDenominacion())==null)
            return crearTipoPilotoRepo.guardar(tipoPilotoCrear);
        throw new TipoPilotoExisteException();
    }
}
