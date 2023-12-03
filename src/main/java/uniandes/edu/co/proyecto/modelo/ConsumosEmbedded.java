package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import java.util.List;

public class ConsumosEmbedded {
    
    private Date fecha;
    private Boolean pagado;
    private ServicioEmbedded servicio;
    
    public ConsumosEmbedded() {
        super();
    }

    public ConsumosEmbedded(Date fecha, Boolean pagado, ServicioEmbedded servicio) {
        super();
        this.fecha = fecha;
        this.pagado = pagado;
        this.servicio = servicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public ServicioEmbedded getServicio() {
        return servicio;
    }

    public void setServicio(ServicioEmbedded servicio) {
        this.servicio = servicio;
    }

    

    
}
