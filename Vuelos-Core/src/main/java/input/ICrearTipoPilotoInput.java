package input;

import excepciones.TipoPilotoExisteException;
import modelo.TipoPiloto;

public interface ICrearTipoPilotoInput {

    boolean crearTipoPiloto(TipoPiloto tipoPilotoCrear) throws TipoPilotoExisteException;
}
