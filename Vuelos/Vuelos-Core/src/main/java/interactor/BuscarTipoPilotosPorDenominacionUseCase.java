package interactor;

import modelo.TipoPiloto;
import repositorio.IBuscarTipoPilotosPorDenominacionRepo;

import java.util.List;

public class BuscarTipoPilotosPorDenominacionUseCase {
    private IBuscarTipoPilotosPorDenominacionRepo buscarTipoPilotosPorDenominacionRepo;

    public BuscarTipoPilotosPorDenominacionUseCase(IBuscarTipoPilotosPorDenominacionRepo buscarTipoPilotosPorDenominacionRepo) {
        this.buscarTipoPilotosPorDenominacionRepo = buscarTipoPilotosPorDenominacionRepo;
    }

    public List<TipoPiloto> buscarTipoPilotosPorDenominacion(String denominacion){
        return (List<TipoPiloto>) buscarTipoPilotosPorDenominacionRepo.buscarTipoPilotosPorDenominacion(denominacion);

    }
}
