package input;

import modelo.TipoPiloto;

import java.util.List;

public interface IBuscarTipoPilotosPorDenominacionInput {

    public List<TipoPiloto> buscarTipoPilotosPorDenominacion(String denominacion);
}
