
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
    //Agregar cuenta de consumo
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentaConsumos(pagado, idReserva, fecha) " +
                "SELECT :pagado, r.idReserva, :fecha " +
                "FROM Reservas r " +
                "WHERE r.Habitaciones_id.id = :Habitaciones_id",
        nativeQuery = true)
    void insertarConsumo(@Param("pagado") boolean pagado, @Param("Habitaciones_id") Integer Habitaciones_id, @Param("fecha") String fecha);

    //Actualizar consumo
    @Modifying
    @Transactional
    
    @Query(value = "UPDATE cuentaConsumos SET pagado = :pagado, fecha = :fecha " +
                    "WHERE idReserva IN (SELECT r.idReserva FROM Reservas r " +
                                        "WHERE r.Habitaciones_id.id = :Habitaciones_id)",
            nativeQuery = true)
        
    void actualizarConsumo(@Param("pagado") boolean pagado, @Param("Habitaciones_id") Integer Habitaciones_id, @Param("fecha") String fecha);

    //Borrar consumo
    @Modifying
    @Query(value = "DELETE FROM cuentaConsumos " +
                "WHERE idReserva IN (SELECT r.idReserva FROM Reservas r " +
                                    "WHERE r.Habitaciones_id.id = :Habitaciones_id)",
        nativeQuery = true)
    void borrarConsumosPorNumeroHabitacion(@Param("Habitaciones_id") Integer Habitaciones_id);





}