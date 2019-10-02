package ar.edu.undec.prog.repositorioCRUD;

import ar.edu.undec.prog.modeloEntity.TipoPilotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrearTipoPilotoCRUD extends CrudRepository <TipoPilotoEntity, Integer> {
}
