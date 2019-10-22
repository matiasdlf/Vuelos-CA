package interactorUnitTest;

import mockito.MockitoExtension;
import excepciones.PilotoIncompletoException;
import excepciones.TipoPilotoIncompletoException;
import interactor.BuscarPilotosPorNombreUseCase;
import modelo.Piloto;
import modelo.TipoPiloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import repositorio.IBuscarPilotosPorNombreRepo;

import java.util.ArrayList;
import java.util.List;

import static modelo.Piloto.factoryPiloto;
import static modelo.TipoPiloto.factoryTipoPiloto;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarPilotosPorNombreUnitTest {

    @Mock
    IBuscarPilotosPorNombreRepo buscarPilotosPorNombreRepo;

    @Spy
    List<Piloto> pilotos =factoryListaPilotos();

    @Test
    public void buscarPilotosPorNombre_ExistenPilotos_devuelveLista() throws PilotoIncompletoException {
        when(buscarPilotosPorNombreRepo.buscarPilotosPorNombre("Juan")).thenReturn(pilotos);
        BuscarPilotosPorNombreUseCase buscarPilotosPorNombreUseCase=new BuscarPilotosPorNombreUseCase(buscarPilotosPorNombreRepo);
        List<Piloto> resultado=buscarPilotosPorNombreUseCase.buscarPilotosPorNombre("Juan");
        Assertions.assertEquals(2,resultado.size());
    }

    public List<Piloto> factoryListaPilotos() {
        try {
            List<Piloto> losPilotos=new ArrayList<>();
            TipoPiloto elTipo= factoryTipoPiloto(1, "Comandante");
            Piloto pilotoJuanPerez= factoryPiloto(1,"Perez","Juan","12134", elTipo);
            Piloto pilotoJuanGomez= factoryPiloto(2,"Gomez","Juan","12135", elTipo);
            losPilotos.add(pilotoJuanGomez);
            losPilotos.add(pilotoJuanPerez);
            return losPilotos;
        } catch (PilotoIncompletoException | TipoPilotoIncompletoException pie) {
            pie.printStackTrace();
            return new ArrayList<>();
        }
    }
}
