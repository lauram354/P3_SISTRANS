package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Maquinas")
public class Maquinas {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer maquinas_id;

    private String nombre;

    //CONSTRUCTORS

    public Maquinas()
    {;}

    public Maquinas(String nombre) {
        this.nombre = nombre;
    }

    //GETTER y SETTERS

    public Integer getMaquinasId() {
        return maquinas_id;
    }

    public void setMaquinasId(Integer idMaquina) {
        this.maquinas_id = idMaquina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
