package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoteles")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombre;
    private Integer estrellas;
    private Integer cant_habitaciones;

    public Hotel(String nombre, Integer estrellas, Integer cant_habitaciones)
    {
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.cant_habitaciones = cant_habitaciones;
    }

    public Hotel()
    {;}


    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public Integer getCant_habitaciones() {
        return cant_habitaciones;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public void setCant_habitaciones(Integer cant_habitaciones) {
        this.cant_habitaciones = cant_habitaciones;
    }    
    
}
