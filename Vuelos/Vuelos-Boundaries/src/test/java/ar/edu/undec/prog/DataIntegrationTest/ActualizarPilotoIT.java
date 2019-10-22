package ar.edu.undec.prog.DataIntegrationTest;

import ar.edu.undec.prog.Data.RepositorioImplementacion.ActualizarPilotoRepoImpl;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:actualizarPilotoAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:actualizarPilotoDespues.sql")
})
public class ActualizarPilotoIT {

    @Autowired
    ActualizarPilotoRepoImpl actualizarPilotoRepoImpl;

    @Test
    public void actualizarPiloto_pilotoGuardado_devuelveTrue() throws PilotoIncompletoException, TipoPilotoIncompletoException {
        TipoPiloto elTipoPiloto=TipoPiloto.factoryTipoPiloto(1, "Comandante");
        Piloto elPiloto= Piloto.factoryPiloto(1,"Perez","Juan","12345678", elTipoPiloto);
        boolean resultado= actualizarPilotoRepoImpl.guardar(elPiloto);
        assertTrue(resultado);
    }
}
