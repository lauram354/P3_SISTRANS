package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Piscinas")
public class Piscinas {

    @Id
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Servicios idServicio;

    private Integer capacidad;
    private Float profundidad;
    private Float costo;

    public Piscinas()
    {;}

    public Piscinas(Integer capacidad, Float profundidad, Float costo) {
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.costo = costo;
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Float getProfundidad() {
        return profundidad;
    }

    public Float getCosto() {
        return costo;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

}
