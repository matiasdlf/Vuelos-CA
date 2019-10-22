package ar.edu.undec.prog.DataIntegrationTest;

import ar.edu.undec.prog.Data.RepositorioImplementacion.BuscarPilotosPorNombreRepoImpl;
import modelo.Piloto;
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
public class BuscarPilotosPorNombreIT {

    @Autowired
    BuscarPilotosPorNombreRepoImpl buscarPilotosPorNombreRepoImpl;

    @Test
    @SqlGroup({
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:buscarPilotoPorNombreAntes.sql"),
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:buscarPilotoPorNombreDespues.sql")
    })
    public void buscarPilotoPorNombre_existenPilotos_devuelveListado() {
        List<Piloto> losPilotos = (List<Piloto>) buscarPilotosPorNombreRepoImpl.buscarPilotosPorNombre("Juan");
        assertEquals(2, losPilotos.size());
    }
}
