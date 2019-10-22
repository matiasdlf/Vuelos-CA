package ar.edu.undec.prog.Data.RepositorioCRUD;

import ar.edu.undec.prog.Data.ModeloEntity.PilotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuscarPilotosPorDniCRUD extends CrudRepository<PilotoEntity, Integer> {
    PilotoEntity findByDni(String documento);
}
