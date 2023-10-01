package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Gimnasios")
public class Gimnasios {

    @Id
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Servicios idServicio;

    private Integer capacidad;
    private Float costo;

    //CONSTRUCTORS

    public Gimnasios()
    {;}

    public Gimnasios(Integer capacidad, Float costo) {
        this.capacidad = capacidad;
        this.costo = costo;
    }

    //GETTERS

    public Servicios getIdServicio() {
        return idServicio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Float getCosto() {
        return costo;
    }

    //SETTERS

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

}
