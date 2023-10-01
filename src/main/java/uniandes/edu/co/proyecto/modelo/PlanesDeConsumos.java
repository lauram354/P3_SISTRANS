package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder.In;

@Entity
@Table(name="PlanesConsum")
public class PlanesDeConsumos {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String tipo;

    private Float descuento;
    private Integer dias;

    @ManyToOne
    @JoinColumn(name = "Hoteles_nombreHotel", referencedColumnName = "nombreHotel")
    private Hoteles nombreHotel;

    //CONSTRUCTORS

    public PlanesDeConsumos() 
    {;}

    public PlanesDeConsumos(Float descuento, Integer dias, Hoteles nombreHotel) {
        this.descuento = descuento;
        this.dias = dias;
        this.nombreHotel = nombreHotel;
    }

    //GETTERS

    public String getTipo() {
        return tipo;
    }

    public Float getDescuento() {
        return descuento;
    }

    public Integer getDias() {
        return dias;
    }

    public Hoteles getNombreHotel() {
        return nombreHotel;
    }

    //SETTERS

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public void setNombreHotel(Hoteles nombreHotel) {
        this.nombreHotel = nombreHotel;
    }   
    
}
