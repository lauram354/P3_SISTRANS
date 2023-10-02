package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;

@RestController
public class UsuariosController {
    @Autowired 
    private UsuariosRepository usuariosRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model){
        model.addAttribute("usuarios", usuariosRepository.darUsuarios());
        return model.toString();
    }

    @GetMapping("/usuarios/new")
    public String usuariosForm(Model model){
        model.addAttribute("usuarios", new Usuarios());
        return "usuarioNuevo";
    }
    
    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuarios usuarios){
        usuariosRepository.insertarUsuario(usuarios.getIdUsuario(), usuarios.getNombreUsuario(), usuarios.getEmail(), usuarios.getRol(), usuarios.getNombreHotel().toString(), usuarios.getTipoId());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") int id, Model model){
        Usuarios usuario = usuariosRepository.darUsuario(id);
        if (usuario != null){
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else{
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Usuarios usuario ){
        usuariosRepository.actualizarUsuario(id, usuario.getNombreUsuario(),usuario.getEmail(), usuario.getRol(), usuario.getNombreHotel().toString(), usuario.getTipoId());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") int id){
        usuariosRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}
