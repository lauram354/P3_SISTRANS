package uniandes.edu.co.proyecto;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Reservan;
import uniandes.edu.co.proyecto.modelo.ReservanPK;
import uniandes.edu.co.proyecto.modelo.Reservas;
import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.modelo.tipoHabitaciones;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;
import uniandes.edu.co.proyecto.repositorio.tipoHabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ReservasRepository;
//import uniandes.edu.co.proyecto.repositorio.cuentaConsumoRepository;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private ReservasRepository ReservasRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) 
	{
		// TODO Auto-generated method stub
		Collection<Reservas> Reservas = ReservasRepository.darReserva(1);
		//for (Reservas b:Reservas){
		//	System.out.println(b);
		//}
		
		
	}

}
