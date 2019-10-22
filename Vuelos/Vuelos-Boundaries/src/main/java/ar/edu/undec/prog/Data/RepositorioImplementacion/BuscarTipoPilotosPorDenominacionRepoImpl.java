package ar.edu.undec.prog.Data.RepositorioImplementacion;

import ar.edu.undec.prog.Data.EntityMapper.TipoPilotoEntityMapper;
import ar.edu.undec.prog.Data.ModeloEntity.TipoPilotoEntity;
import ar.edu.undec.prog.Data.RepositorioCRUD.IBuscarTipoPilotosPorDenominacionCRUD;
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
            TipoPiloto tipoPiloto = new TipoPilotoEntityMapper().mapeoDataCore(elTipoPiloto);
            tipoPilotoBuscados.add(tipoPiloto);
        }
        return tipoPilotoBuscados;
    }
}
