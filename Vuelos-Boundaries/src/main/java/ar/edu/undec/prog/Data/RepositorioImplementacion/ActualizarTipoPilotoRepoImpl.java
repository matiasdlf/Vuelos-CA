package ar.edu.undec.prog.Data.RepositorioImplementacion;

import ar.edu.undec.prog.Data.EntityMapper.TipoPilotoEntityMapper;
import ar.edu.undec.prog.Data.ModeloEntity.TipoPilotoEntity;
import ar.edu.undec.prog.Data.RepositorioCRUD.IActualizarTipoPilotoCRUD;
import ar.edu.undec.prog.Data.RepositorioCRUD.IBuscarTipoPilotosPorDenominacionCRUD;
import modelo.TipoPiloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IActualizarTipoPilotoRepo;

@Service
public class ActualizarTipoPilotoRepoImpl implements IActualizarTipoPilotoRepo {
    @Autowired
    IActualizarTipoPilotoCRUD actualizarTipoPilotoCRUD;

    @Autowired
    IBuscarTipoPilotosPorDenominacionCRUD buscarTipoPilotosPorDenominacionCRUD;

    @Override
    public boolean actualizar(TipoPiloto tipoPilotoNuevo) {
        TipoPilotoEntity elTipoPilotoAGuardar = new TipoPilotoEntityMapper().mapeoCoreData(tipoPilotoNuevo);
        return actualizarTipoPilotoCRUD.save(elTipoPilotoAGuardar).getIdTipoPiloto() != null;
    }

    @Override
    public TipoPiloto findByIdTipoPiloto(Integer id) {
        TipoPilotoEntity elTipoPilotoEntity = actualizarTipoPilotoCRUD.findByIdTipoPiloto(id);
        if (elTipoPilotoEntity != null) {
            return new TipoPilotoEntityMapper().mapeoDataCore(elTipoPilotoEntity);
        }
        return null;
    }

    @Override
    public TipoPiloto findByDenominacion(String denominacion) {
        TipoPilotoEntity elTipoPilotoEntity = actualizarTipoPilotoCRUD.findByDenominacion(denominacion);
        if (elTipoPilotoEntity != null) {
            return new TipoPilotoEntityMapper().mapeoDataCore(elTipoPilotoEntity);
        }
        return null;
    }
}
