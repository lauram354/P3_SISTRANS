package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class serviciosHotelPK implements Serializable{

    @ManyToOne
    @JoinColumn(name = "Hoteles:nombreHotel", referencedColumnName = "nombreHotel")
    private Hoteles nombreHotel;

    @ManyToOne
    @JoinColumn(name = "Servicios_idServicio", referencedColumnName = "idServicio")
    private Servicios idServicio;

    //CONSTRUCTOR

    public serviciosHotelPK(Hoteles nombreHotel, Servicios idServicio) {
        super();
        this.nombreHotel = nombreHotel;
        this.idServicio = idServicio;
    }

    //GETTERS

    public Hoteles getNombreHotel() {
        return nombreHotel;
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    //SETTERS

    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }
    
}
