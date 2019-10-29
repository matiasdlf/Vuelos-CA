package ar.edu.undec.prog.DataIntegrationTest;

import ar.edu.undec.prog.Data.RepositorioImplementacion.ActualizarTipoPilotoRepoImpl;
import ar.edu.undec.prog.Data.RepositorioImplementacion.CrearTipoPilotoRepoImpl;
import excepciones.TipoPilotoIncompletoException;
import modelo.TipoPiloto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:actualizarTipoPilotoAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:actualizarTipoPilotoDespues.sql")
})

public class ActualizarTipoPilotoIT {
    @Autowired
    private ActualizarTipoPilotoRepoImpl actualizarTipoPilotoRepoImpl;

    @Test
    public void actualizarTipoPiloto_tipoPilotoGuardado_devuelveTrue() throws TipoPilotoIncompletoException {
        TipoPiloto elTipoPiloto = TipoPiloto.factoryTipoPiloto(1, "Comandanteee");
        boolean resultado = actualizarTipoPilotoRepoImpl.actualizar(elTipoPiloto);
        assertTrue(resultado);
    }
}
