package ar.edu.undec.prog.ServiceIntegrationTest;

import ar.edu.undec.prog.Service.Controller.CrearTipoPilotoController;
import ar.edu.undec.prog.Service.ModeloService.TipoPilotoDTO;
import excepciones.TipoPilotoExisteException;
import input.ICrearTipoPilotoInput;
import modelo.TipoPiloto;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearTipoPilotoServiceIT {


    @Mock
    ICrearTipoPilotoInput crearTipoPilotoInput;

    @Test
    public void crearTipoPiloto_TipoPilotoNoExiste_Devuelve200() throws Exception {
        TipoPilotoDTO elTipoPiloto=new TipoPilotoDTO(null,"Comandante");
        when(crearTipoPilotoInput.crearTipoPiloto(any(TipoPiloto.class))).thenReturn(true);
        CrearTipoPilotoController crearTipoPilotoController=new CrearTipoPilotoController(crearTipoPilotoInput);
        assertEquals(crearTipoPilotoController.crearTipoPiloto(elTipoPiloto).getStatusCodeValue(), HttpStatus.SC_OK);
    }

    @Test
    public void crearTipoPiloto_TipoPilotoExiste_Devuelve412() throws Exception {
        TipoPilotoDTO elTipoPiloto=new TipoPilotoDTO(1,"Comandante");
        when(crearTipoPilotoInput.crearTipoPiloto(any(TipoPiloto.class))).thenThrow(new TipoPilotoExisteException());
        CrearTipoPilotoController crearTipoPilotoController=new CrearTipoPilotoController(crearTipoPilotoInput);
        assertEquals(crearTipoPilotoController.crearTipoPiloto(elTipoPiloto).getStatusCodeValue(), HttpStatus.SC_PRECONDITION_FAILED);
    }
}
