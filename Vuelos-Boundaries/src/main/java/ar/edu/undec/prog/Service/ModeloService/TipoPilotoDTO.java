package ar.edu.undec.prog.Service.ModeloService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoPilotoDTO {

    @JsonProperty("idTipoPiloto")
    private Integer idTipoPiloto;
    @JsonProperty("denominacion")
    private String denominacion;

    public TipoPilotoDTO(@JsonProperty("idTipoPiloto") Integer idTipoPiloto,
                         @JsonProperty("denominacion") String denominacion) {

        this.idTipoPiloto = idTipoPiloto;
        this.denominacion = denominacion;
    }

    public Integer getIdTipoPiloto() {
        return idTipoPiloto;
    }

    public void setIdTipoPiloto(Integer idTipoPiloto) {
        this.idTipoPiloto = idTipoPiloto;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

}
