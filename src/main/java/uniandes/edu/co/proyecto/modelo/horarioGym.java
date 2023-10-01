package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="horarioGym")
public class horarioGym {

    @EmbeddedId
    private horarioGymPK pk;

    //CONSTRUCTORS

    public horarioGym()
    {;}

    public horarioGym(Gimnasios idGimnasio, Horarios idHorario) {
        this.pk = new horarioGymPK(idGimnasio, idHorario);
    }

    //GETTERS

    public horarioGymPK getPk() {
        return pk;
    }

    //SETTERS

    public void setPk(horarioGymPK pk) {
        this.pk = pk;
    }
    
}
