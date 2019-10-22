package ar.edu.undec.prog.Service.Config;

import interactor.BuscarTipoPilotosPorDenominacionUseCase;
import interactor.CrearTipoPilotoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorio.IBuscarTipoPilotosPorDenominacionRepo;
import repositorio.ICrearTipoPilotoRepo;

@Configuration
public class UseCaseConfig {

    @Autowired
    private ICrearTipoPilotoRepo iCrearTipoPilotoRepo;

    @Autowired
    private IBuscarTipoPilotosPorDenominacionRepo iBuscarTipoPilotosPorDenominacionRepo;

    @Bean
    public CrearTipoPilotoUseCase crearTipoPilotoUseCase() {
        return new CrearTipoPilotoUseCase(iCrearTipoPilotoRepo);
    }

    @Bean
    public BuscarTipoPilotosPorDenominacionUseCase buscarTipoPilotosPorDenominacionUseCase() {
        return new BuscarTipoPilotosPorDenominacionUseCase(iBuscarTipoPilotosPorDenominacionRepo);
    }

}
