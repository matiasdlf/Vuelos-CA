package interactorUnitTest;

import mockito.MockitoExtension;
import excepciones.PilotoExisteException;
import excepciones.PilotoIncompletoException;
import excepciones.TipoPilotoIncompletoException;
import interactor.CrearPilotoUseCase;
import modelo.Piloto;
import modelo.TipoPiloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.ICrearPilotoRepo;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearPilotoUnitTest {

    @Mock
    ICrearPilotoRepo crearPilotoRepo;


    @Test
    public void crearPiloto_PilotoNoExiste_GuardaCorrectamente() throws PilotoIncompletoException, PilotoExisteException, TipoPilotoIncompletoException {
        Piloto pilotoNuevo=Piloto.factoryPiloto(1,"Perez", "Juan","12345678", TipoPiloto.factoryTipoPiloto(1, "Comandante"));
        when(crearPilotoRepo.guardar(pilotoNuevo)).thenReturn(true);
        CrearPilotoUseCase crearPilotoUseCase = new CrearPilotoUseCase(crearPilotoRepo);
        boolean resultado = crearPilotoUseCase.crearPiloto(pilotoNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearPiloto_PilotoExiste_PilotoExisteException() throws PilotoIncompletoException, TipoPilotoIncompletoException {
        Piloto pilotoNuevo = Piloto.factoryPiloto(1,"Perez", "Juan","12345678", TipoPiloto.factoryTipoPiloto(1, "Comandante"));
        when(crearPilotoRepo.findByDNI("12345678")).thenReturn(Piloto.factoryPiloto(2,"Lopez", "Carlos","12345678", TipoPiloto.factoryTipoPiloto(1, "Comandante")));
        CrearPilotoUseCase crearPilotoUseCase = new CrearPilotoUseCase(crearPilotoRepo);
        Assertions.assertThrows(PilotoExisteException.class, () -> crearPilotoUseCase.crearPiloto(pilotoNuevo));

    }
}
