package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="consumoHabitacion")
public class consumoHabitacion {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private consumoHabitacionPK idCuenta;

    private Integer cantidad;
    private Integer costo;

    //CONSTRUCTORS

    public consumoHabitacion()
    {;}

    public consumoHabitacion(Integer cantidad, Integer costo) {
        this.cantidad = cantidad;
        this.costo = costo;
    }

    //GETTERS

    public consumoHabitacionPK getIdCuenta() {
        return idCuenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getCosto() {
        return costo;
    }

    //SETTERS

    public void setIdCuenta(consumoHabitacionPK idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }  
    
}
