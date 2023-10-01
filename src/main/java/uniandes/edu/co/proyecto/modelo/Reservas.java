package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservas")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReserva;

    private Integer numPersonas;
    private String fechaInicial;
    private String fechaFinal;

    @ManyToOne
    @JoinColumn(name = "Habitaciones_id", referencedColumnName = "id")
    private Habitaciones Habitaciones_id;

    @ManyToOne
    @JoinColumn(name = "PlanesDeConsumos_tipo", referencedColumnName = "tipo")
    private PlanesDeConsumos tipo;

    //CONSTRUCTORS
    
    public Reservas()
    {;}

    public Reservas(Integer numPersonas, String fechaInicial, String fechaFinal, Habitaciones habitaciones_id,
            PlanesDeConsumos tipo) {
        this.numPersonas = numPersonas;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.Habitaciones_id = habitaciones_id;
        this.tipo = tipo;
    }

    //GETTERS

    public Integer getIdReserva() {
        return idReserva;
    }

    public Integer getNumPersonas() {
        return numPersonas;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public Habitaciones getHabitaciones_id() {
        return Habitaciones_id;
    }

    public PlanesDeConsumos getTipo() {
        return tipo;
    }

    //SETTERS

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setHabitaciones_id(Habitaciones habitaciones_id) {
        Habitaciones_id = habitaciones_id;
    }

    public void setTipo(PlanesDeConsumos tipo) {
        this.tipo = tipo;
    }

}
