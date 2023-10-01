package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class horarioPiscinaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Piscinas_idServicio", referencedColumnName = "idServicio")
    private Piscinas idPiscina;

    @ManyToOne
    @JoinColumn(name = "Horarios_idServicio", referencedColumnName = "idServicio")
    private Horarios idHorario;

    //CONSTRUCTOR

    public horarioPiscinaPK(Piscinas idPiscina, Horarios idHorario) {
        this.idPiscina = idPiscina;
        this.idHorario = idHorario;
    }
    
    //GETTERS

    public horarioPiscinaPK() 
    {;}

    public Piscinas getIdPiscina() {
        return idPiscina;
    }

    public Horarios getIdHorario() {
        return idHorario;
    }

    //SETTERS

    public void setIdPiscina(Piscinas idPiscina) {
        this.idPiscina = idPiscina;
    }

    public void setIdHorario(Horarios idHorario) {
        this.idHorario = idHorario;
    }
    
}
