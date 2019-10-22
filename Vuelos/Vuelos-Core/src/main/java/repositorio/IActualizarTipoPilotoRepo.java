package repositorio;

import modelo.TipoPiloto;

import java.util.Collection;

public interface IActualizarTipoPilotoRepo {

    boolean actualizar(TipoPiloto tipoPilotoDatosNuevos);

    TipoPiloto findByIdTipoPiloto(Integer id);

    Collection<TipoPiloto> findTipoPilotosPorDenominacion(String denominacion);
}
