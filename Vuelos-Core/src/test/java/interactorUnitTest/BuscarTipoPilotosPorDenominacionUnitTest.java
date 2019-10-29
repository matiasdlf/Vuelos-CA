package interactorUnitTest;

import mockito.MockitoExtension;
import excepciones.TipoPilotoIncompletoException;
import interactor.BuscarTipoPilotosPorDenominacionUseCase;
import modelo.TipoPiloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import repositorio.IBuscarTipoPilotosPorDenominacionRepo;

import java.util.ArrayList;
import java.util.List;

import static modelo.TipoPiloto.factoryTipoPiloto;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BuscarTipoPilotosPorDenominacionUnitTest {
    @Mock
    IBuscarTipoPilotosPorDenominacionRepo buscarTipoPilotosPorDenominacion;

    @Spy
    List<TipoPiloto> tipoPilotos = factoryListaTipoPilotos();

    @Test
    public void buscarTipoPilotosPorDenominacion_ExistenTipoPilotos_devuelveLista() {
        when(buscarTipoPilotosPorDenominacion.buscarTipoPilotosPorDenominacion("Comandante")).thenReturn(tipoPilotos);
        BuscarTipoPilotosPorDenominacionUseCase buscarTipoPilotosPorDenominacionUseCase = new BuscarTipoPilotosPorDenominacionUseCase(buscarTipoPilotosPorDenominacion);
        List<TipoPiloto> resultado = buscarTipoPilotosPorDenominacionUseCase.buscarTipoPilotosPorDenominacion("Comandante");
        Assertions.assertEquals(1,resultado.size());
    }

    private List<TipoPiloto> factoryListaTipoPilotos() {
        try {
            List<TipoPiloto> losTipoPilotos = new ArrayList<>();
            TipoPiloto elTipo1= factoryTipoPiloto(1, "Comandante");
            losTipoPilotos.add(elTipo1);
            return losTipoPilotos;
        } catch (TipoPilotoIncompletoException pie) {
            pie.printStackTrace();
            return new ArrayList<>();
        }
    }

}
