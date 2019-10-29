package input;

import excepciones.TipoPilotoExisteException;
import modelo.TipoPiloto;

public interface IActualizarTipoPilotoInput {

    boolean actualizarTipoPiloto(TipoPiloto tipoPilotoCrear) throws TipoPilotoExisteException;
}
