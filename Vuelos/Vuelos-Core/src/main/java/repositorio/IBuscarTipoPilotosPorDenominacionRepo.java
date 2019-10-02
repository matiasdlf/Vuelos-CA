package repositorio;

import modelo.TipoPiloto;

import java.util.Collection;

public interface IBuscarTipoPilotosPorDenominacionRepo {
    Collection<TipoPiloto> buscarTipoPilotosPorDenominacion(String denominacion);
}
