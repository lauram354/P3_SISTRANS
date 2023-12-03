package uniandes.edu.co.proyecto.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.repository.HotelRepository;



@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;


    @GetMapping("/reservas")
    public String obtenerTodasLasReservas(Model model){
        model.addAttribute("hotel", hotelRepository.findAll());
        return "reservas";
    }

    @GetMapping("/")
    public String home(Model model){
        return "index";
    }

    @GetMapping("/tiposHabi")
    public String obtenerTodasLosTiposHabi(Model model){
        model.addAttribute("tiposHabi", hotelRepository.findAll());
        return "tiposHabi";
    }

     @GetMapping("/habis")
    public String obtenerTodasLasHabitaciones(Model model){
        model.addAttribute("hotel", hotelRepository.findAll());
        return "habis";
    }

     @GetMapping("/servicios")
    public String obtenerTodasLosServicios(Model model){
        model.addAttribute("hotel", hotelRepository.findAll());
        return "servicios";
    }

     @GetMapping("/consumos")
    public String obtenerTodasLosConsumos(Model model){
        model.addAttribute("hotel", hotelRepository.findAll());
        return "consumos";
    }
    
}
