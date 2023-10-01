package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="servHotel")
public class serviciosHotel {

    @EmbeddedId
    private serviciosHotelPK pk;

    //CONSTRUCTORS

    public serviciosHotel()
    {;}

    public serviciosHotel(Hoteles nombreHotel, Servicios idServicio) {
        this.pk = new serviciosHotelPK(nombreHotel, idServicio);
    }

    //GETTERS

    public serviciosHotelPK getPk() {
        return pk;
    }

    //SETTERS

    public void setPk(serviciosHotelPK pk) {
        this.pk = pk;
    }    
    
}
