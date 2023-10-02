package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="registroServicios")
public class registroServicios {

    @EmbeddedId
    private registroServiciosPK pk;

    public registroServicios() 
    {;}

    private String fecha;

    public registroServicios(Servicios idServicio, Reservas idReserva, String fecha) {
        this.pk = new registroServiciosPK(idServicio, idReserva);
        this.fecha = fecha;
    }

    //GETTERS

    public registroServiciosPK getPk() {
        return pk;
    }
   
    public String getFecha() {
        return fecha;
    }

    
    //SETTERS

    public void setPk(registroServiciosPK pk) {
        this.pk = pk;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
