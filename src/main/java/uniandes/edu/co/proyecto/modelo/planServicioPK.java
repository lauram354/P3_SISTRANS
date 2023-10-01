package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class planServicioPK {
    
    @ManyToOne
    @JoinColumn(name = "PlanesConsum_tipo", referencedColumnName = "tipo")
    private PlanesDeConsumos planesConsum_tipo;

    @ManyToOne
    @JoinColumn(name = "Servicios_idServicio", referencedColumnName = "idServicio")
    private Servicios idServicio;

    public planServicioPK(PlanesDeConsumos planesConsum_tipo, Servicios idServicio) {
        super();
        this.planesConsum_tipo = planesConsum_tipo;
        this.idServicio = idServicio;
    }

    public planServicioPK() {;
    }

    public PlanesDeConsumos getPlanesConsum_tipo() {
        return planesConsum_tipo;
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    public void setPlanesConsum_tipo(PlanesDeConsumos planesConsum_tipo) {
        this.planesConsum_tipo = planesConsum_tipo;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }
    
}
