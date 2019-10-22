package repositorio;

import modelo.TipoPiloto;

public interface ICrearTipoPilotoRepo {
    boolean guardar(TipoPiloto tipoPilotoCrear);

    TipoPiloto findByIdTipoPiloto(Integer id);
    TipoPiloto findByDenominacion(String denominacion);
}
