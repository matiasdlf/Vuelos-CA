package ar.edu.undec.prog.Data.RepositorioImplementacion;

import ar.edu.undec.prog.Data.EntityMapper.PilotoEntityMapper;
import ar.edu.undec.prog.Data.ModeloEntity.PilotoEntity;
import ar.edu.undec.prog.Data.RepositorioCRUD.IActualizarPilotoCRUD;
import modelo.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IActualizarPilotoRepo;

@Service
public class ActualizarPilotoRepoImpl implements IActualizarPilotoRepo {

    @Autowired
    IActualizarPilotoCRUD actualizarPilotoCRUD;

    @Override
    public boolean guardar(Piloto pilotoDatosNuevos) {
        PilotoEntity elPilotoAGuardar=new PilotoEntityMapper().mapeoCoreData(pilotoDatosNuevos);
        return actualizarPilotoCRUD.save(elPilotoAGuardar)!=null;
    }

    @Override
    public Piloto findByDNI(String dni) {
        Piloto elPiloto=new PilotoEntityMapper().mapeoDataCore(actualizarPilotoCRUD.findByDni(dni));
        if(elPiloto!=null){
            return elPiloto;
        }
        return null;
    }
}
