package ar.edu.undec.prog.repositorioImplementacion;

import ar.edu.undec.prog.mapper.TipoPilotoMapper;
import ar.edu.undec.prog.modeloEntity.TipoPilotoEntity;
import ar.edu.undec.prog.repositorioCRUD.ICrearTipoPilotoCRUD;
import modelo.TipoPiloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositorio.ICrearTipoPilotoRepo;

@Repository
public class CrearTipoPilotoRepoImpl implements ICrearTipoPilotoRepo {

    @Autowired
    ICrearTipoPilotoCRUD crearTipoPilotoCRUD;

    @Override
    public boolean guardar(TipoPiloto tipoPilotoNuevo) {
        TipoPilotoEntity elTipoPilotoAGuardar = new TipoPilotoMapper().mapeoCoreData(tipoPilotoNuevo);
        return crearTipoPilotoCRUD.save(elTipoPilotoAGuardar).getIdTipoPiloto()!=null;
    }

    @Override
    public TipoPiloto findByDenominacion(String denominacion) {
        return null;
    }
}
