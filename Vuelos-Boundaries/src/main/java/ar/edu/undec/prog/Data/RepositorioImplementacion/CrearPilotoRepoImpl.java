package ar.edu.undec.prog.Data.RepositorioImplementacion;

import ar.edu.undec.prog.Data.EntityMapper.PilotoEntityMapper;
import ar.edu.undec.prog.Data.ModeloEntity.PilotoEntity;
import ar.edu.undec.prog.Data.RepositorioCRUD.IBuscarPilotosPorDniCRUD;
import ar.edu.undec.prog.Data.RepositorioCRUD.ICrearPilotoCRUD;
import modelo.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositorio.ICrearPilotoRepo;

@Repository
public class CrearPilotoRepoImpl implements ICrearPilotoRepo {


    @Autowired
    ICrearPilotoCRUD crearPilotoCRUD;

    @Autowired
    IBuscarPilotosPorDniCRUD buscarPilotosPorDNI;

    @Override
    public boolean guardar(Piloto pilotoNuevo) {
        PilotoEntity elPilotoAGuardar=new PilotoEntityMapper().mapeoCoreData(pilotoNuevo);
        return crearPilotoCRUD.save(elPilotoAGuardar).getIdPiloto()!=null;
    }

    @Override
    public Piloto findByDNI(String pDNI) {
        Piloto elPiloto=new PilotoEntityMapper().mapeoDataCore(buscarPilotosPorDNI.findByDni(pDNI));
        if(elPiloto!=null){
            return elPiloto;
        }
        return null;
    }

}
