package input;

import modelo.TipoPiloto;

import java.util.List;

public interface IBuscarTipoPilotosPorDenominacionInput {

    List<TipoPiloto> buscarTipoPilotosPorDenominacion(String denominacion);
}
