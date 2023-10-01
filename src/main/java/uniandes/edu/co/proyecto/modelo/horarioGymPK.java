package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class horarioGymPK {

    @ManyToOne
    @JoinColumn(name = "Gimnasios_idServicio", referencedColumnName = "idServicio")
    private Gimnasios idGimnasio;

    @ManyToOne
    @JoinColumn(name = "Horarios_idServicio", referencedColumnName = "idServicio")
    private Horarios idHorario;

    //CONSTRUCTOR

    public horarioGymPK(Gimnasios idGimnasio, Horarios idHorario) {
        super();
        this.idGimnasio = idGimnasio;
        this.idHorario = idHorario;
    }

    //GETTERS

    public Gimnasios getIdGimnasio() {
        return idGimnasio;
    }

    public Horarios getIdHorario() {
        return idHorario;
    }

    //SETTERS

    public void setIdGimnasio(Gimnasios idGimnasio) {
        this.idGimnasio = idGimnasio;
    }

    public void setIdHorario(Horarios idHorario) {
        this.idHorario = idHorario;
    }
    
}
