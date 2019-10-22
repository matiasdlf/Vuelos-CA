package ar.edu.undec.prog.Data.RepositorioCRUD;

import ar.edu.undec.prog.Data.ModeloEntity.PilotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBuscarPilotosPorNombreCRUD extends CrudRepository<PilotoEntity,Integer> {

    List<PilotoEntity> findByNombreContains(String nombre);
}
