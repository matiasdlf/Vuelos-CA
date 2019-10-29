package modeloTest;

import excepciones.TipoPilotoIncompletoException;
import modelo.TipoPiloto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TipoPilotoUnitTest {

    @Test
    public void factoryTipoPiloto_AtributosCorrectos_InstanciaCorrecta() throws TipoPilotoIncompletoException {
        TipoPiloto elTipoPiloto=TipoPiloto.factoryTipoPiloto(null,"Comandante");
        Assertions.assertNotNull(elTipoPiloto);
    }

    @Test
    public void factoryTipoPiloto_AtributosIncompletos_TipoPilotoIncompletoException() {
        Assertions.assertThrows(TipoPilotoIncompletoException.class, ()->TipoPiloto.factoryTipoPiloto(null,null));
    }
}
