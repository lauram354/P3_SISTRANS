package uniandes.edu.co.proyecto.modelo;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "hotel")
public class Hotel{
   @Id
    private String id;

    
    private Date inicio;
    private Date fin;
    private Integer diasreserva;
    private Boolean checkin;
    private Boolean checkout;

    // Lista de habitaciones embebidas en el documento principal
    private List<HabitacionesEmbedded> Habitaciones;
    private List<ClientesEmbedded> Clientes;
    private List<ConsumosEmbedded> Consumos;


    public Hotel(){
        //Constructor vacio para el uso de Spring
    }

    

    public Hotel(String id, Date inicio, Date fin, Integer diasreserva, Boolean checkin, Boolean checkout,
            List<HabitacionesEmbedded> habitaciones, List<ClientesEmbedded> clientes, List<ConsumosEmbedded> consumos) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.diasreserva = diasreserva;
        this.checkin = checkin;
        this.checkout = checkout;
        Habitaciones = habitaciones;
        Clientes = clientes;
        Consumos = consumos;
    }



    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public Date getInicio() {
        return inicio;
    }


    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }


    public Date getFin() {
        return fin;
    }


    public void setFin(Date fin) {
        this.fin = fin;
    }


    public Integer getDiasreserva() {
        return diasreserva;
    }


    public void setDiasreserva(Integer diasreserva) {
        this.diasreserva = diasreserva;
    }


    public Boolean getCheckin() {
        return checkin;
    }


    public void setCheckin(Boolean checkin) {
        this.checkin = checkin;
    }


    public Boolean getCheckout() {
        return checkout;
    }


    public void setCheckout(Boolean checkout) {
        this.checkout = checkout;
    }


    public List<HabitacionesEmbedded> getHabitaciones() {
        return Habitaciones;
    }


    public void setHabitaciones(List<HabitacionesEmbedded> habitaciones) {
        Habitaciones = habitaciones;
    }


    public List<ClientesEmbedded> getClientes() {
        return Clientes;
    }


    public void setClientes(List<ClientesEmbedded> clientes) {
        Clientes = clientes;
    }


    public List<ConsumosEmbedded> getConsumos() {
        return Consumos;
    }


    public void setConsumos(List<ConsumosEmbedded> consumos) {
        Consumos = consumos;
    }

    


    
}
