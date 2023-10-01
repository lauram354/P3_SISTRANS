
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
    @Query(value = "INSERT INTO cuentaConsumos(pagado, idReserva, fecha) " +
                "SELECT :pagado, r.idReserva, :fecha " +
                "FROM Reservas r " +
                "WHERE r.Habitaciones_id.id = :Habitaciones_id",
        nativeQuery = true)
    void insertarConsumo(@Param("pagado") boolean pagado, @Param("Habitaciones_id") Integer Habitaciones_id, @Param("fecha") String fecha);


}