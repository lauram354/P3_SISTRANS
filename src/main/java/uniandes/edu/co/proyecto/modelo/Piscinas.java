package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Piscinas")
public class Piscinas {

    @EmbeddedId
    private PiscinasPK pk;

    private Integer capacidad;
    private Float profundidad;
    private Float costo;

    public Piscinas()
    {;}

    public Piscinas(Servicios idServicios, Integer capacidad, Float profundidad, Float costo) {
        this.pk = new PiscinasPK(idServicios);
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.costo = costo;
    }

    public PiscinasPK getPk() {
        return pk;
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

    public void setPk(PiscinasPK pk) {
        this.pk = pk;
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
