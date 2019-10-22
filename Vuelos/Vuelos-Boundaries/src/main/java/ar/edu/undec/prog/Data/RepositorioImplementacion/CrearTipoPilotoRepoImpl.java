package ar.edu.undec.prog.Data.RepositorioImplementacion;

import ar.edu.undec.prog.Data.EntityMapper.TipoPilotoEntityMapper;
import ar.edu.undec.prog.Data.ModeloEntity.TipoPilotoEntity;
import ar.edu.undec.prog.Data.RepositorioCRUD.IBuscarTipoPilotosPorDenominacionCRUD;
import ar.edu.undec.prog.Data.RepositorioCRUD.ICrearTipoPilotoCRUD;
import modelo.TipoPiloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.ICrearTipoPilotoRepo;

@Service
public class CrearTipoPilotoRepoImpl implements ICrearTipoPilotoRepo {

    @Autowired
    ICrearTipoPilotoCRUD crearTipoPilotoCRUD;

    @Autowired
    IBuscarTipoPilotosPorDenominacionCRUD buscarTipoPilotosPorDenominacionCRUD;

    @Override
    public boolean guardar(TipoPiloto tipoPilotoNuevo) {
        TipoPilotoEntity elTipoPilotoAGuardar = new TipoPilotoEntityMapper().mapeoCoreData(tipoPilotoNuevo);
        return crearTipoPilotoCRUD.save(elTipoPilotoAGuardar).getIdTipoPiloto() != null;
    }

    @Override
    public TipoPiloto findByIdTipoPiloto(Integer id) {
        TipoPilotoEntity elTipoPilotoEntity = crearTipoPilotoCRUD.findByIdTipoPiloto(id);
        if (elTipoPilotoEntity != null) {
            return new TipoPilotoEntityMapper().mapeoDataCore(elTipoPilotoEntity);
        }
        return null;
    }

    @Override
    public TipoPiloto findByDenominacion(String denominacion) {
        TipoPilotoEntity elTipoPilotoEntity = crearTipoPilotoCRUD.findByDenominacion(denominacion);
        if (elTipoPilotoEntity != null) {
            return new TipoPilotoEntityMapper().mapeoDataCore(elTipoPilotoEntity);
        }
        return null;
    }
}
