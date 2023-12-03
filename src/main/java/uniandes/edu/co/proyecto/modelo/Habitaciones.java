package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "habitaciones")

public class Habitaciones {
    @Id 
    private String _id;

    @Field("numero")
    private Integer numero;

    @Field("dotacion")
    private List<String> dotacion;

    @Field("tipohabi")
    private List<tipoHabiEmbedded> tipohabi;

    public Habitaciones() {
    }

    public Habitaciones(String _id, Integer numero, List<String> dotacion, List<tipoHabiEmbedded> tipohabi) {
        this._id = _id;
        this.numero = numero;
        this.dotacion = dotacion;
        this.tipohabi = tipohabi;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<String> getDotacion() {
        return dotacion;
    }

    public void setDotacion(List<String> dotacion) {
        this.dotacion = dotacion;
    }

    public List<tipoHabiEmbedded> getTipohabi() {
        return tipohabi;
    }

    public void setTipohabi(List<tipoHabiEmbedded> tipohabi) {
        this.tipohabi = tipohabi;
    }

    

}
