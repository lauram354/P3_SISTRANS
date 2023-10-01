package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservanPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Usuarios_idUsuario", referencedColumnName = "idUsuario")
    private Usuarios idUsuario;

    @ManyToOne
    @JoinColumn(name = "Reservas_idReserva", referencedColumnName = "idReserva")
    private Reservas idReserva;

    public ReservanPK(Usuarios idUsuario, Reservas idReserva) {
        super();
        this.idUsuario = idUsuario;
        this.idReserva = idReserva;
    }

    //GETTERS

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public Reservas getIdReserva() {
        return idReserva;
    }

    //SETTERS

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdReserva(Reservas idReserva) {
        this.idReserva = idReserva;
    }

}
