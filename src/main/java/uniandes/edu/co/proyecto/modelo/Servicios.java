package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Servicios")
public class Servicios {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer idServicio;

    private String tipo;

    //CONSTRUCTORS

    public Servicios()
    {;}

    public Servicios(String tipo) {
        this.tipo = tipo;
    }

    //GETTERS

    public Integer getIdServicio() {
        return idServicio;
    }

    public String getTipo() {
        return tipo;
    }

    //SETTERS

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
