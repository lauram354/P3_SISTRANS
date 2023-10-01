package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentaConsumos")
public class cuentaConsumos {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String idCuenta;

    private Boolean pagado;

    @ManyToOne
    @JoinColumn(name = "Reservas_idReserva", referencedColumnName = "idReserva")
    private Reservas idReserva;

    //CONSTRUCTORS

    public cuentaConsumos()
    {;}

    public cuentaConsumos(Boolean pagado, Reservas idReserva) {
        this.pagado = pagado;
        this.idReserva = idReserva;
    }

    //GETTERS

    public String getIdCuenta() {
        return idCuenta;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public Reservas getIdReserva() {
        return idReserva;
    }

    //SETTERS

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public void setIdReserva(Reservas idReserva) {
        this.idReserva = idReserva;
    }

}
