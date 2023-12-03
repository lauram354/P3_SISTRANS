package uniandes.edu.co.proyecto.modelo;

import java.util.List;

public class HabitacionesEmbedded {

    private Integer numero;
    private List<String> dotacion;
    private tipoHabiEmbedded tipohabi;


    public HabitacionesEmbedded() {
        super();
    }

    
    public HabitacionesEmbedded(Integer numero, List<String> dotacion, tipoHabiEmbedded tipohabi) {
        super();
        this.numero = numero;
        this.dotacion = dotacion;
        this.tipohabi = tipohabi;
    }


    public Integer getnumero() {
        return numero;
    }
    public List<String> getDotacion() {
        return dotacion;
    }
    public tipoHabiEmbedded getTipohabi() {
        return tipohabi;
    }
    
    public void setnumero(Integer numero) {
        this.numero = numero;
    }
    public void setDotacion(List<String> dotacion) {
        this.dotacion = dotacion;
    }
    public void setTipohabi(tipoHabiEmbedded tipohabi) {
        this.tipohabi = tipohabi;
    }

    

}
