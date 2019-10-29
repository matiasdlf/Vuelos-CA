package interactorUnitTest;

import mockito.MockitoExtension;
import excepciones.PilotoExisteException;
import excepciones.PilotoIncompletoException;
import excepciones.TipoPilotoIncompletoException;
import interactor.ActualizarPilotoUseCase;
import modelo.Piloto;
import modelo.TipoPiloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IActualizarPilotoRepo;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActualizarPilotoUnitTest {

    @Mock
    IActualizarPilotoRepo actualizarPilotoRepo;


    @Test
    public void actualizarPiloto_NoHayConflictoPilotoExistente_GuardaCorrectamente() throws TipoPilotoIncompletoException, PilotoIncompletoException, PilotoExisteException {
        Piloto pilotoDatosNuevos=Piloto.factoryPiloto(1,"Lopez", "Jorge","000111222", TipoPiloto.factoryTipoPiloto(1, "Comandante"));
        when(actualizarPilotoRepo.findByDNI("000111222")).thenReturn(null);
        when(actualizarPilotoRepo.actualizar(pilotoDatosNuevos)).thenReturn(true);

        ActualizarPilotoUseCase actualizarPilotoUseCase = new ActualizarPilotoUseCase(actualizarPilotoRepo);
        boolean resultado = actualizarPilotoUseCase.actualizarPiloto(pilotoDatosNuevos);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void actualizarPiloto_ConflictoConPilotoExistente_PilotoExisteException() throws TipoPilotoIncompletoException, PilotoIncompletoException {
        Piloto pilotoDatosNuevos=Piloto.factoryPiloto(1,"Lopez", "Jorge","12345678", TipoPiloto.factoryTipoPiloto(1, "Comandante"));
        when(actualizarPilotoRepo.findByDNI("12345678")).thenReturn(Piloto.factoryPiloto(2,"Paez", "Carlos","12345678", TipoPiloto.factoryTipoPiloto(1, "Comandante")));
        ActualizarPilotoUseCase actualizarPilotoUseCase= new ActualizarPilotoUseCase(actualizarPilotoRepo);
        Assertions.assertThrows(PilotoExisteException.class, () -> actualizarPilotoUseCase.actualizarPiloto(pilotoDatosNuevos));

    }

    @Test
    public void actualizarPiloto_ConflictoConPilotoExistentePeroEsElMismo_GuardaCorrectamente() throws TipoPilotoIncompletoException, PilotoIncompletoException, PilotoExisteException {
        Piloto pilotoDatosNuevos=Piloto.factoryPiloto(1,"Lopez", "Jorge","12345678", TipoPiloto.factoryTipoPiloto(1, "Comandante"));
        when(actualizarPilotoRepo.findByDNI("12345678")).thenReturn(Piloto.factoryPiloto(1,"Paez", "Carlos","12345678", TipoPiloto.factoryTipoPiloto(1, "Comandante")));
        when(actualizarPilotoRepo.actualizar(pilotoDatosNuevos)).thenReturn(true);
        ActualizarPilotoUseCase actualizarPilotoUseCase= new ActualizarPilotoUseCase(actualizarPilotoRepo);
        boolean resultado = actualizarPilotoUseCase.actualizarPiloto(pilotoDatosNuevos);
        Assertions.assertTrue(resultado);

    }
}
