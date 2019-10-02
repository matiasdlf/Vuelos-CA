package ar.edu.undec.prog;

import ar.edu.undec.prog.repositorioImplementacion.CrearTipoPilotoRepoImpl;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearTipoPilotoAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearTipoPilotoDespues.sql")
})

public class CrearTipoPilotoIT {
    @Autowired
    CrearTipoPilotoRepoImpl crearTipoPilotoRepoImpl;

    @Test
    public void guardarTipoPiloto_tipoPilotoGuardado_devuelveTrue() throws TipoPilotoIncompletoException {
        TipoPiloto elTipoPiloto = TipoPiloto.factoryTipoPiloto(null, "Comandante");
        boolean resultado = crearTipoPilotoRepoImpl.guardar(elTipoPiloto);
        assertTrue(resultado);
    }
}
