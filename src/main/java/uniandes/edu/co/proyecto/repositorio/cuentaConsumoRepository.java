
package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.cuentaConsumos;

public interface cuentaConsumoRepository extends JpaRepository<cuentaConsumos, Integer>{

    //RF10 
    //Toca colocar que solo empleado
    //
    //
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentaConsumos(pagado, idReserva, fecha) VALUES (:pagado, :(SELECT idReserva, numPersonas, fechaInicial, fechaFinal, Habitaciones_id, tipo, Usuarios_idUsuario, check_in, check_out FROM Reservas WHERE Habitaciones_id= : 
    Habitaciones_id), :fecha)", nativeQuery = true)
    void insertarConsumo(@Param("pagado") boolean pagado, @Param("Habitaciones_id") String nombreUsuario, @Param("email") String email, @Param("rol") String rol, @Param("Hoteles_nombreHotel") String Hoteles_nombreHotel, @Param("tipoId") String tipoId);

}