package ar.edu.undec.prog.Service.Config;

import interactor.ActualizarTipoPilotoUseCase;
import interactor.BuscarTipoPilotosPorDenominacionUseCase;
import interactor.CrearTipoPilotoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorio.IActualizarTipoPilotoRepo;
import repositorio.IBuscarTipoPilotosPorDenominacionRepo;
import repositorio.ICrearTipoPilotoRepo;

@Configuration
public class UseCaseConfig {

    @Autowired
    private ICrearTipoPilotoRepo iCrearTipoPilotoRepo;

    @Autowired
    private IActualizarTipoPilotoRepo iActualizarTipoPilotoRepo;

    @Autowired
    private IBuscarTipoPilotosPorDenominacionRepo iBuscarTipoPilotosPorDenominacionRepo;

    @Bean
    public CrearTipoPilotoUseCase crearTipoPilotoUseCase() {
        return new CrearTipoPilotoUseCase(iCrearTipoPilotoRepo);
    }

    @Bean
    public ActualizarTipoPilotoUseCase actualizarTipoPilotoUseCase() {return new ActualizarTipoPilotoUseCase(iActualizarTipoPilotoRepo); }

    @Bean
    public BuscarTipoPilotosPorDenominacionUseCase buscarTipoPilotosPorDenominacionUseCase() {
        return new BuscarTipoPilotosPorDenominacionUseCase(iBuscarTipoPilotosPorDenominacionRepo);
    }

}
