package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class consumoHabitacionPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "productsHabi_producto", referencedColumnName = "producto")
    private productosHabitacion productosHabitacion;

    @ManyToOne
    @JoinColumn(name = "cuentaConsu_idCuenta", referencedColumnName = "idCuenta")
    private cuentaConsumos id_bebida;

    //CONSTRUCTOR

    public consumoHabitacionPK(productosHabitacion productosHabitacion, cuentaConsumos id_bebida) {
        super();
        this.productosHabitacion = productosHabitacion;
        this.id_bebida = id_bebida;
    }
    

    public consumoHabitacionPK() {;
    }

    //GETTERS
    public productosHabitacion getProductosHabitacion() {
        return productosHabitacion;
    }

    public cuentaConsumos getId_bebida() {
        return id_bebida;
    }

    //SETTERS

    public void setProductosHabitacion(productosHabitacion productosHabitacion) {
        this.productosHabitacion = productosHabitacion;
    }

    public void setId_bebida(cuentaConsumos id_bebida) {
        this.id_bebida = id_bebida;
    }
    
}
