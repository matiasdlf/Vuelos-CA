package ar.edu.undec.prog.Data.EntityMapper;

import ar.edu.undec.prog.Data.ModeloEntity.TipoPilotoEntity;
import excepciones.TipoPilotoIncompletoException;
import modelo.TipoPiloto;

public class TipoPilotoEntityMapper {


    public TipoPilotoEntity mapeoCoreData(TipoPiloto tipoPilotoCore) {
        TipoPilotoEntity elTipo = new TipoPilotoEntity();
        elTipo.setIdTipoPiloto(tipoPilotoCore.getIdTipoPiloto());
        elTipo.setDenominacion(tipoPilotoCore.getDenominacion());
        return elTipo;

    }

    public TipoPiloto mapeoDataCore(TipoPilotoEntity elTipoPiloto) {
        try {
            return TipoPiloto.factoryTipoPiloto(elTipoPiloto.getIdTipoPiloto(), elTipoPiloto.getDenominacion());
        } catch (TipoPilotoIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
