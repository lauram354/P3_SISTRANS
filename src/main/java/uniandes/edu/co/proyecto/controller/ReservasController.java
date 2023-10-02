package uniandes.edu.co.proyecto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Reservas;
import uniandes.edu.co.proyecto.repositorio.ReservasRepository;

public class ReservasController {
    @Autowired 
    private ReservasRepository reservasRepository;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/reservas")
    public String usuarios(Model model){
        model.addAttribute("reservas", reservasRepository.darReservas());
        return model.toString();
    }

    @GetMapping("/reservas/new")
    public String reservasForm(Model model){
        model.addAttribute("reservas", new Reservas());
        return "reservaNuevo";
    }
    
    @PostMapping("/reservas/new/save")
    public String reservasGuardar(@ModelAttribute Reservas reserva) throws ParseException{
        java.sql.Date fi = new java.sql.Date(dateFormat.parse(reserva.getFechaInicial()).getTime());
        java.sql.Date ff = new java.sql.Date(dateFormat.parse(reserva.getFechaFinal()).getTime());

        reservasRepository.insertarReserva(reserva.getIdReserva(), reserva.getNumPersonas().toString(), fi, ff, reserva.getTipo().toString());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") int id, Model model){
        Reservas reserva = reservasRepository.darReserva(id);
        if (reserva != null){
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else{
            return "redirect:/reservas";
        }
    }

    @PostMapping("/reservas/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Reservas reserva ) throws ParseException{
        java.sql.Date fi = new java.sql.Date(dateFormat.parse(reserva.getFechaInicial()).getTime());
        java.sql.Date ff = new java.sql.Date(dateFormat.parse(reserva.getFechaFinal()).getTime());
        reservasRepository.actualizarReserva(id, reserva.getNumPersonas().toString(), fi, ff, reserva.getTipo().toString());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") int id){
        reservasRepository.eliminarReserva(id);
        return "redirect:/reservas";
    }
    
}
