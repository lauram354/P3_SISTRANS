package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="horarioPisc")
public class horarioPiscina {

    @EmbeddedId
    private horarioPiscinaPK pk;

    //CONSTRUCTORS

    public horarioPiscina()
    {;}

    public horarioPiscina(Piscinas idPiscina, Horarios idHorario) {
        super();
        this.pk = new horarioPiscinaPK(idPiscina, idHorario);
    }

    //GETTERS

    public horarioPiscinaPK getPk() {
        return pk;
    }

    //SETTERS

    public void setPk(horarioPiscinaPK pk) {
        this.pk = pk;
    }
    
}
