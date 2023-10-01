package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class maquinasGymPK {

    @ManyToOne
    @JoinColumn(name = "Gimnasios_idServicio", referencedColumnName = "idServicio")
    private Gimnasios idServicio;

    @ManyToOne
    @JoinColumn(name = "maquinas_maquinas_id", referencedColumnName = "maquinas_id")
    private Maquinas idMaquina;

    //CONSTRUCTOR

    public maquinasGymPK(Gimnasios idServicio, Maquinas idMaquina) {
        super();
        this.idServicio = idServicio;
        this.idMaquina = idMaquina;
    }

    //GETTERS Y SETTERS

    public Gimnasios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Gimnasios idServicio) {
        this.idServicio = idServicio;
    }

    public Maquinas getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Maquinas idMaquina) {
        this.idMaquina = idMaquina;
    }

}
