package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class GimnasiosPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Servicios idServicio;

    public GimnasiosPK(Servicios idServicio) {
        super();
        this.idServicio = idServicio;
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }
    
}
