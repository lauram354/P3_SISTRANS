package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentaConsu")
public class cuentaConsumos {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCuenta;
    
    private Boolean pagado;

    @ManyToOne
    @JoinColumn(name = "Reservas_idReserva", referencedColumnName = "idReserva")
    private Reservas idReserva;

    private String fecha;
    //CONSTRUCTORS

    public cuentaConsumos()
    {;}

    public cuentaConsumos(Boolean pagado, Reservas idReserva, String fecha) {
        this.pagado = pagado;
        this.idReserva = idReserva;
        this.fecha = fecha;
    }

    //GETTERS

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public Reservas getIdReserva() {
        return idReserva;
    }

    public String getFecha() {
        return fecha;
    }

    
    //SETTERS

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public void setIdReserva(Reservas idReserva) {
        this.idReserva = idReserva;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
