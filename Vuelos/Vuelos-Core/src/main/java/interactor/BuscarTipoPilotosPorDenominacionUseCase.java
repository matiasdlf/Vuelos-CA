package interactor;

import input.IBuscarTipoPilotosPorDenominacionInput;
import modelo.TipoPiloto;
import repositorio.IBuscarTipoPilotosPorDenominacionRepo;

import java.util.List;

public class BuscarTipoPilotosPorDenominacionUseCase implements IBuscarTipoPilotosPorDenominacionInput {
    private IBuscarTipoPilotosPorDenominacionRepo buscarTipoPilotosPorDenominacionRepo;

    public BuscarTipoPilotosPorDenominacionUseCase(IBuscarTipoPilotosPorDenominacionRepo buscarTipoPilotosPorDenominacionRepo) {
        this.buscarTipoPilotosPorDenominacionRepo = buscarTipoPilotosPorDenominacionRepo;
    }

    @Override
    public List<TipoPiloto> buscarTipoPilotosPorDenominacion(String denominacion){
        return (List<TipoPiloto>) buscarTipoPilotosPorDenominacionRepo.buscarTipoPilotosPorDenominacion(denominacion);

    }
}
