package modelo;

import excepciones.TipoPilotoIncompletoException;

public class TipoPiloto {
    private final Integer idTipoPiloto;
    private final String denominacion;

    public TipoPiloto(Integer idTipoPiloto, String denominacion) {

        this.idTipoPiloto = idTipoPiloto;
        this.denominacion = denominacion;
    }

    public static TipoPiloto factoryTipoPiloto(Integer idTipoPiloto, String denominacion) throws TipoPilotoIncompletoException {
        if(denominacion==null) throw new TipoPilotoIncompletoException();
        return new TipoPiloto(idTipoPiloto,denominacion);
    }

    public String getDenominacion() {
        return this.denominacion;
    }

    public Integer getIdTipoPiloto() {
        return idTipoPiloto;
    }
}
