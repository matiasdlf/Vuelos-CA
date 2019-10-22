package ar.edu.undec.prog.DataIntegrationTest;

import ar.edu.undec.prog.Data.RepositorioImplementacion.CrearPilotoRepoImpl;
import excepciones.PilotoIncompletoException;
import excepciones.TipoPilotoIncompletoException;
import modelo.Piloto;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearPilotoAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:crearPilotoDespues.sql")
})
public class CrearPilotoIT {

    @Autowired
    CrearPilotoRepoImpl crearPilotoRepoImpl;

    @Test
    public void guardarPiloto_pilotoGuardado_devuelveTrue() throws PilotoIncompletoException, TipoPilotoIncompletoException {
        TipoPiloto elTipoPiloto=TipoPiloto.factoryTipoPiloto(1, "Comandante");
        Piloto elPiloto= Piloto.factoryPiloto(null,"Perez","Juan","12345678", elTipoPiloto);
        boolean resultado= crearPilotoRepoImpl.guardar(elPiloto);
        assertTrue(resultado);
    }
}
