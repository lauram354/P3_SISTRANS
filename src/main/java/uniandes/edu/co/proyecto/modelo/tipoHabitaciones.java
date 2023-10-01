package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tipoHabi")
public class tipoHabitaciones {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String tipo;

    private Integer capacidad;

    //CONSTRUCTORS

    public tipoHabitaciones()
    {;}

    public tipoHabitaciones(Integer capacidad) {
        this.capacidad = capacidad;
    }

    //GETTERS

    public String getTipo() {
        return tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    //SETTERS

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }      

}
