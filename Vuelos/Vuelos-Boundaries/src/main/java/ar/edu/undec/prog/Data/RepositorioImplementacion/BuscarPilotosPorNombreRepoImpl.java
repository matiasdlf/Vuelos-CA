package ar.edu.undec.prog.Data.RepositorioImplementacion;

import ar.edu.undec.prog.Data.EntityMapper.PilotoEntityMapper;
import ar.edu.undec.prog.Data.ModeloEntity.PilotoEntity;
import ar.edu.undec.prog.Data.RepositorioCRUD.IBuscarPilotosPorNombreCRUD;
import modelo.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IBuscarPilotosPorNombreRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BuscarPilotosPorNombreRepoImpl implements IBuscarPilotosPorNombreRepo {
    @Autowired
    IBuscarPilotosPorNombreCRUD iBuscarPilotosPorNombreCRUD;

    public Collection<Piloto> buscarPilotosPorNombre(String nombrePiloto) {
        List<Piloto> pilotosBuscados = new ArrayList<>();
        for (PilotoEntity elPiloto : iBuscarPilotosPorNombreCRUD.findByNombreContains(nombrePiloto)) {
            Piloto piloto = new PilotoEntityMapper().mapeoDataCore(elPiloto);
            pilotosBuscados.add(piloto);
        }
        return pilotosBuscados;
    }
}
