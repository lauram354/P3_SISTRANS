package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="maquiGym")
public class maquinasGym {

    @EmbeddedId
    private maquinasGymPK pk;
    public maquinasGym(Maquinas idMaquina, Gimnasios idServicio){
        this.pk = new maquinasGymPK(idServicio, idMaquina);
    }
    public maquinasGym()
    {;}
    public maquinasGymPK getPk() {
        return pk;
    }
    public void setPk(maquinasGymPK pk) {
        this.pk = pk;
    }
    
}
