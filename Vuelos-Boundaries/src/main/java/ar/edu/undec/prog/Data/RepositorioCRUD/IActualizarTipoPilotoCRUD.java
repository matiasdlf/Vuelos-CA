package ar.edu.undec.prog.Data.RepositorioCRUD;

import ar.edu.undec.prog.Data.ModeloEntity.TipoPilotoEntity;
import org.springframework.data.repository.CrudRepository;

public interface IActualizarTipoPilotoCRUD extends CrudRepository<TipoPilotoEntity, Integer> {
    TipoPilotoEntity findByIdTipoPiloto(Integer id);
    TipoPilotoEntity findByDenominacion(String denominacion);
}
