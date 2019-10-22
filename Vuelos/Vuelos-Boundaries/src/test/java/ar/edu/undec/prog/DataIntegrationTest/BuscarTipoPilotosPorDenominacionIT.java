package ar.edu.undec.prog.DataIntegrationTest;

import ar.edu.undec.prog.Data.RepositorioImplementacion.BuscarTipoPilotosPorDenominacionRepoImpl;
import modelo.TipoPiloto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuscarTipoPilotosPorDenominacionIT {

    @Autowired
    BuscarTipoPilotosPorDenominacionRepoImpl buscarTipoPilotosPorDenominacionRepo;

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:buscarTipoPilotosPorDenominacionAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:buscarTipoPilotosPorDenominacionDespues.sql")
    })
    public void buscarTipoPilotosPorDenominacion_existenTipoPilotos_devuelveListado() {
        List<TipoPiloto> losTipoPilotos = (List<TipoPiloto>) buscarTipoPilotosPorDenominacionRepo.buscarTipoPilotosPorDenominacion("Comandante");
        assertEquals(1, losTipoPilotos.size());
    }
}
