package interactorUnitTest;

import mockito.MockitoExtension;
import excepciones.TipoPilotoExisteException;
import excepciones.TipoPilotoIncompletoException;
import interactor.CrearTipoPilotoUseCase;
import modelo.TipoPiloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.ICrearTipoPilotoRepo;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearTipoPilotoUnitTest {

    @Mock
    ICrearTipoPilotoRepo crearTipoPilotoRepo;

    @Test
    public void crearTipoPiloto_TipoPilotoNoExiste_TipoPilotoCreadoCorrectamente() throws TipoPilotoIncompletoException, TipoPilotoExisteException {
        TipoPiloto tipoPilotoCrear=TipoPiloto.factoryTipoPiloto(null,"Comandante");
        when(crearTipoPilotoRepo.guardar(tipoPilotoCrear)).thenReturn(true);
        CrearTipoPilotoUseCase crearTipoPilotoUseCase=new CrearTipoPilotoUseCase(crearTipoPilotoRepo);
        boolean resultado=crearTipoPilotoUseCase.crearTipoPiloto(tipoPilotoCrear);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearTipoTipoPiloto_TipoPilotoExiste_TipoPilotoExisteException() throws TipoPilotoIncompletoException {
        TipoPiloto TipoPilotoNuevo = TipoPiloto.factoryTipoPiloto(null,"Comandante");
        when(crearTipoPilotoRepo.findByDenominacion("Comandante")).thenReturn(TipoPiloto.factoryTipoPiloto(1,"Comandante"));
        CrearTipoPilotoUseCase crearTipoPilotoUseCase = new CrearTipoPilotoUseCase(crearTipoPilotoRepo);
        Assertions.assertThrows(TipoPilotoExisteException.class, () -> crearTipoPilotoUseCase.crearTipoPiloto(TipoPilotoNuevo));

    }

}
