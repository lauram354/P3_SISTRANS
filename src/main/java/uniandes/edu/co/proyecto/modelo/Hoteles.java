package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hoteles")
public class Hoteles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombre;
    
    private Integer cant_habitaciones;

    public Hoteles(String nombre, Integer cant_habitaciones)
    {
        this.nombre = nombre;
        this.cant_habitaciones = cant_habitaciones;
    }

    public Hoteles()
    {;}


    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public Integer getCant_habitaciones() {
        return cant_habitaciones;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCant_habitaciones(Integer cant_habitaciones) {
        this.cant_habitaciones = cant_habitaciones;
    }    
    
}
