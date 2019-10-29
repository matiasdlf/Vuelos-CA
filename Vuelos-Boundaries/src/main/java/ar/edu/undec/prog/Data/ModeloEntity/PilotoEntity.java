package ar.edu.undec.prog.Data.ModeloEntity;

import javax.persistence.*;

@Entity(name = "pilotos")
@SequenceGenerator(name = "seq_piloto", sequenceName = "seq_piloto", initialValue = 1, allocationSize = 1)
public class PilotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_piloto")
    private Integer idPiloto;

    private String apellido;

    private String nombre;

    private String dni;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tipo_piloto_id")
    private TipoPilotoEntity tipoPiloto;

    public PilotoEntity() {
    }

    public Integer getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Integer idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public TipoPilotoEntity getTipoPiloto() {
        return tipoPiloto;
    }

    public void setTipoPiloto(TipoPilotoEntity tipoPiloto) {
        this.tipoPiloto = tipoPiloto;
    }

}
