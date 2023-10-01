package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productosHabitacion")
public class productosHabitacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String producto;

    private Float costo;

    @ManyToOne
    @JoinColumn(name = "Habitaciones_id", referencedColumnName = "id")
    private Habitaciones idHabitaciones;

    //CONSTRUCTORS

    public productosHabitacion()
    {;}

    public productosHabitacion(Float costo, Habitaciones idHabitaciones) {
        this.costo = costo;
        this.idHabitaciones = idHabitaciones;
    }

    //GETTERS

    public String getProducto() {
        return producto;
    }

    public Float getCosto() {
        return costo;
    }

    public Habitaciones getIdHabitaciones() {
        return idHabitaciones;
    }

    //SETTERS

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public void setIdHabitaciones(Habitaciones idHabitaciones) {
        this.idHabitaciones = idHabitaciones;
    }

}
