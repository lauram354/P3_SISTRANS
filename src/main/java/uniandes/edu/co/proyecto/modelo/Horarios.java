package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Horarios")
public class Horarios {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private String idHorario;

    private String horaInicial;
    private String horaFinal;
    private String dias;

    //CONSTRUCTORS

    public Horarios()
    {;}

    public Horarios(String horaInicial, String horaFinal, String dias) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.dias = dias;
    }

    //GETTERS y SETTERS

    public String getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

}
