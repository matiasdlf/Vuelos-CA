package ar.edu.undec.prog.repositorioImplementacion;

import ar.edu.undec.prog.mapper.TipoPilotoMapper;
import ar.edu.undec.prog.modeloEntity.TipoPilotoEntity;
import ar.edu.undec.prog.repositorioCRUD.IBuscarTipoPilotosPorDenominacionCRUD;
import modelo.TipoPiloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IBuscarTipoPilotosPorDenominacionRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BuscarTipoPilotosPorDenominacionRepoImpl implements IBuscarTipoPilotosPorDenominacionRepo {

    @Autowired
    IBuscarTipoPilotosPorDenominacionCRUD iBuscarTipoPilotosPorDenominacionCRUD;

    public Collection<TipoPiloto> buscarTipoPilotosPorDenominacion(String denominacion) {
        List<TipoPiloto> tipoPilotoBuscados =new ArrayList<>();
        for(TipoPilotoEntity elTipoPiloto : iBuscarTipoPilotosPorDenominacionCRUD.findByDenominacionContains(denominacion)) {
            TipoPiloto tipoPiloto = new TipoPilotoMapper().mapeoDataCore(elTipoPiloto);
            tipoPilotoBuscados.add(tipoPiloto);
        }
        return tipoPilotoBuscados;
    }
}
