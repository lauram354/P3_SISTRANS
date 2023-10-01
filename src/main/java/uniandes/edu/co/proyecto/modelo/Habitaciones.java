package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Habitaciones")
public class Habitaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tipo;
    private Boolean tv;
    private Boolean miniBar;
    private Boolean cafetera;

    @ManyToOne
    @JoinColumn(name = "Hoteles_nombreHotel", referencedColumnName = "nombreHotel")
    private Hoteles nombreHotel;

    @ManyToOne
    @JoinColumn(name = "tipoHabi_tipo", referencedColumnName = "tipo")
    private tipoHabitaciones tipoHabitaciones;

    //CONSTRUCTORS

    public Habitaciones()
    {;}

    public Habitaciones(String tipo, Boolean tv, Boolean miniBar, Boolean cafetera, Hoteles nombreHotel,
            uniandes.edu.co.proyecto.modelo.tipoHabitaciones tipoHabitaciones) {
        this.tipo = tipo;
        this.tv = tv;
        this.miniBar = miniBar;
        this.cafetera = cafetera;
        this.nombreHotel = nombreHotel;
        this.tipoHabitaciones = tipoHabitaciones;
    }

    //GETTERS

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public Boolean getTv() {
        return tv;
    }

    public Boolean getMiniBar() {
        return miniBar;
    }

    public Boolean getCafetera() {
        return cafetera;
    }

    public Hoteles getNombreHotel() {
        return nombreHotel;
    }

    public tipoHabitaciones getTipoHabitaciones() {
        return tipoHabitaciones;
    }

    //SETTERS

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public void setMiniBar(Boolean miniBar) {
        this.miniBar = miniBar;
    }

    public void setCafetera(Boolean cafetera) {
        this.cafetera = cafetera;
    }

    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public void setTipoHabitaciones(tipoHabitaciones tipoHabitaciones) {
        this.tipoHabitaciones = tipoHabitaciones;
    }
    
}
