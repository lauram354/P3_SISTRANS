package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class registroServiciosPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Servicios_idServicio", referencedColumnName = "idServicio")
    private Servicios idServicio;

    @ManyToOne
    @JoinColumn(name = "Reservas_idReserva", referencedColumnName = "idReserva")
    private Reservas idReserva;

    public registroServiciosPK(Servicios idServicio, Reservas idReserva) {
        super();
        this.idServicio = idServicio;
        this.idReserva = idReserva;
    }

    public registroServiciosPK() {;
    }

    //GETTER
    public Servicios getIdServicio() {
        return idServicio;
    }

    public Reservas getIdReserva() {
        return idReserva;
    }


    //SETTER
    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }

    public void setIdReserva(Reservas idReserva) {
        this.idReserva = idReserva;
    }
    


}

