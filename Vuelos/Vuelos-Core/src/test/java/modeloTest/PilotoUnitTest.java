package modeloTest;

import excepciones.PilotoIncompletoException;
import excepciones.TipoPilotoIncompletoException;
import modelo.Piloto;
import modelo.TipoPiloto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PilotoUnitTest {

    @Test
    public void factoryPiloto_TodosLosAtributosOK_instanciaCorrecta() throws PilotoIncompletoException, TipoPilotoIncompletoException {
        Piloto unPiloto=Piloto.factoryPiloto(null,"Perez","Juan","30123123", TipoPiloto.factoryTipoPiloto(1,"Comandante"));
        Assertions.assertNotNull(unPiloto);
    }

    @Test
    public void factoryPiloto_FaltaAlgunAtributo_PilotoIncompletoException(){
        Assertions.assertThrows(PilotoIncompletoException.class, ()-> Piloto.factoryPiloto(null,"Perez",null,"123456", TipoPiloto.factoryTipoPiloto(1, "Comandante")) );
    }
}
