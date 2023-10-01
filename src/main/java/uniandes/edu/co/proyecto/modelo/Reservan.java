package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="reservan")
public class Reservan {

    @EmbeddedId
    private ReservanPK pk;

    public Reservan() 
    {;}

    //CONSTRUCTOR

    public Reservan(Usuarios idUsuario, Reservas idReserva) {
        this.pk = new ReservanPK(idUsuario, idReserva);
    }

    //GETTERS

    public ReservanPK getPk() {
        return pk;
    }

    //SETTERS

    public void setPk(ReservanPK pk) {
        this.pk = pk;
    }
    
}
