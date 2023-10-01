package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planServ")
public class planServicio {

    @EmbeddedId
    private planServicioPK pk;

    private Float descuento;

    //CONSTRUCTORS

    public planServicio()
    {;}

    public planServicio(PlanesDeConsumos planesConsum_tipo, Servicios idServicio, Float descuento) {
        this.pk = new planServicioPK(planesConsum_tipo, idServicio);
        this.descuento = descuento;
    }

    //GETTERS

    public planServicioPK getPk() {
        return pk;
    }

    public Float getDescuento() {
        return descuento;
    }

    //SETTERS

    public void setPk(planServicioPK pk) {
        this.pk = pk;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }
    
}
