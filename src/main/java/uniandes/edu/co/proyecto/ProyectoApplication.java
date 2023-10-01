package uniandes.edu.co.proyecto;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{
	@Autowired
	private UsuariosRepository usuariosRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// TODO Auto-generated method stub
		Collection<Usuarios> usuarios = usuariosRepository.darUsuarios();
		for (Usuarios b:usuarios){
			System.out.println(b);
		}
		
		
	}

}
