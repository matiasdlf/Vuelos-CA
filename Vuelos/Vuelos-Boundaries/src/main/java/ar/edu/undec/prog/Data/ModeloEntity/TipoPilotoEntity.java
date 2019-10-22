package ar.edu.undec.prog.Data.ModeloEntity;

import javax.persistence.*;

@Entity(name="tipos_piloto")
@SequenceGenerator(name="seq_tipo_piloto", sequenceName = "seq_tipo_piloto", initialValue = 1, allocationSize = 1)
public class TipoPilotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_piloto")
    private Integer idTipoPiloto;
    private String denominacion;

    public TipoPilotoEntity() {

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
