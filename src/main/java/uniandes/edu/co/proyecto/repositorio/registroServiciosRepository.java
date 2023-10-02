package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.registroServicios;

public interface registroServiciosRepository extends JpaRepository<registroServicios, Integer>{

    //Agregar 
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO RegistroServicios (servicio, habitacion, fecha) " +
            "SELECT s.servicio, h.habitacion, :fecha " +
            "FROM Reservas r " +
            "INNER JOIN Habitaciones h ON r.Habitaciones_id = h.id " +
            "INNER JOIN Servicios s ON s.tipo = :tipo_servicio " +
            "WHERE h.id = :Habitaciones_id",
            nativeQuery = true)
    void insertarServicios(@Param("tipo_servicio") String tipo_servicio, @Param("Habitaciones_id") Integer Habitaciones_id, @Param("fecha") String fecha);

    //Actualizar
    @Modifying
    @Transactional     
    @Query(value = "UPDATE RegistroServicios rs " +
                "SET rs.servicio = :s.servicio, rs.habitacion = :h.habitacion, rs.fecha = :fecha " +
                "FROM Reservas r " +
                "INNER JOIN Habitaciones h ON r.Habitaciones_id = h.id " +
                "INNER JOIN Servicios s ON s.tipo = :tipo_servicio " +
                "WHERE h.id = :Habitaciones_id",
        nativeQuery = true)

    void actualizarServicios(@Param("tipo_servicio") String tipo_servicio, @Param("Habitaciones_id") Integer Habitaciones_id, @Param("fecha") String fecha);


    //Eliminar
    @Modifying
    @Transactional
    @Query("DELETE FROM RegistroServicios rs WHERE rs.habitacion.id = :habitacionId")
    void eliminarPorIdHabitacion(@Param("habitacionId") Long habitacionId);
    
}