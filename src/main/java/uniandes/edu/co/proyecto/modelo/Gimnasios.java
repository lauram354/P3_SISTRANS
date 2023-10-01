package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Gimnasios")
public class Gimnasios {

    @EmbeddedId
    private GimnasiosPK pk;

    private Integer capacidad;
    private Float costo;

    //CONSTRUCTORS

    public Gimnasios()
    {;}

    public Gimnasios(Servicios idServicio, Integer capacidad, Float costo) {
        this.pk = new GimnasiosPK(idServicio);
        this.capacidad = capacidad;
        this.costo = costo;
    }

    //GETTERS

    public GimnasiosPK getIdServicio() {
        return pk;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Float getCosto() {
        return costo;
    }

    //SETTERS

    public void setPk(GimnasiosPK pk) {
        this.pk = pk;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

}
