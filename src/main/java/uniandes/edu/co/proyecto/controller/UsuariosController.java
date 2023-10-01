package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;

@Controller
public class UsuariosController {
    @Autowired 
    private UsuariosRepository usuariosRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model){
        model.addAttribute("usuarios", usuariosRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuariosForm(Model model){
        model.addAttribute("usuarios", new Usuarios());
        return "usuarioNuevo";
    }
    
    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuarios usuarios){
        usuariosRepository.insertarUsuario(usuarios.getIdUsuario(), usuarios.getNombreUsuario(), usuarios.getEmail(), usuarios.getRol(), usuarios.getNombreHotel(), usuarios.getTipoId());
    }
}
