package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUsuario;

    private String nombreUsuario;
    private String email;
    private String rol;

    @ManyToOne
    @JoinColumn(name = "Hoteles_nombreHotel", referencedColumnName = "nombreHotel")
    private Hoteles nombreHotel;

    public Usuarios()
    {;}

    public Usuarios(String nombreUsuario, String email, String rol, Hoteles nombreHotel) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.rol = rol;
        this.nombreHotel = nombreHotel;
    }

    //GETTERS

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }

    public Hoteles getNombreHotel() {
        return nombreHotel;
    }

    //SETTERS

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }    
    
}
