package uniandes.edu.co.proyecto.modelo;

import java.util.List;

public class HabitacionesEmbedded {

    private Integer _id;
    private List<String> dotacion;
    private List<tipoHabiEmbedded> tipohabi;


    public HabitacionesEmbedded() {
    }

    
    public HabitacionesEmbedded(Integer _id, List<String> dotacion, List<tipoHabiEmbedded> tipohabi) {
        this._id = _id;
        this.dotacion = dotacion;
        this.tipohabi = tipohabi;
    }


    public Integer get_id() {
        return _id;
    }
    public List<String> getDotacion() {
        return dotacion;
    }
    public List<tipoHabiEmbedded> getTipohabi() {
        return tipohabi;
    }
    
    public void set_id(Integer _id) {
        this._id = _id;
    }
    public void setDotacion(List<String> dotacion) {
        this.dotacion = dotacion;
    }
    public void setTipohabi(List<tipoHabiEmbedded> tipohabi) {
        this.tipohabi = tipohabi;
    }

    

}
