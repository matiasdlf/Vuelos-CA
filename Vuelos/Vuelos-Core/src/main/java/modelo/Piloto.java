package modelo;

import excepciones.PilotoIncompletoException;

public class Piloto {

    private final Integer idPiloto;
    private final String apellido;
    private final String nombre;
    private final String dni;
    private TipoPiloto tipoPiloto;

    private Piloto(Integer idPiloto, String apellido, String nombre, String dni, TipoPiloto tipoPiloto) {
        this.idPiloto = idPiloto;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.tipoPiloto = tipoPiloto;
    }

    public static Piloto factoryPiloto(Integer idPiloto, String Apellido, String Nombre, String DNI, TipoPiloto tipoPiloto) throws PilotoIncompletoException {
        if(Apellido==null || Nombre==null || DNI==null || tipoPiloto==null){
            throw new PilotoIncompletoException();
        }
        else
        {
            return new Piloto(idPiloto,Apellido,Nombre,DNI,tipoPiloto);
        }
    }

    public String getDNI() {
        return this.dni;
    }

    public Integer getIdPiloto() {
        return idPiloto;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public TipoPiloto getTipoPiloto() {
        return tipoPiloto;
    }

}
