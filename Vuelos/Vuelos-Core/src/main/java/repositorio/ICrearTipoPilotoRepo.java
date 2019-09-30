package repositorio;

import modelo.TipoPiloto;

public interface ICrearTipoPilotoRepo {
    boolean guardar(TipoPiloto tipoPilotoCrear);

    TipoPiloto findByDenominacion(String denominacion);
}
