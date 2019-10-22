package ar.edu.undec.prog.Data.RepositorioCRUD;

import ar.edu.undec.prog.Data.ModeloEntity.TipoPilotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBuscarTipoPilotosPorDenominacionCRUD extends CrudRepository<TipoPilotoEntity, Integer> {

    List<TipoPilotoEntity> findByDenominacionContains(String denominacion);

    TipoPilotoEntity findByDenominacion(String denominacion);

}
