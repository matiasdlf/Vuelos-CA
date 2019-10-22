package input;

import excepciones.TipoPilotoExisteException;
import modelo.TipoPiloto;

public interface ICrearTipoPilotoInput {

    public boolean crearTipoPiloto(TipoPiloto tipoPilotoCrear) throws TipoPilotoExisteException;
}
