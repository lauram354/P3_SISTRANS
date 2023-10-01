package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Habitaciones;
import uniandes.edu.co.proyecto.modelo.tipoHabitaciones;

public interface habitacionesRepository extends JpaRepository<Habitaciones, Integer>{

    @Query(value = "SELECT * FROM Habitaciones", nativeQuery=true)
    Collection<tipoHabitaciones> darHabitaciones();

    @Query(value = "SELECT * FROM Habitaciones WHERE id= :id", nativeQuery = true)
    tipoHabitaciones darHabitacion(@Param("id") Integer id);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Habitaciones(id, tipo, tv, minibar, cafetera, tipoHabi_tipo, Hoteles_nombreHotel) VALUES ();", nativeQuery = true)
    void insertarTipoHabitacion(@Param("tipo") String tipo, @Param("capacidad") Integer capacidad);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE tipoHabi SET tipo = :tipo, capacidad = :capacidad WHERE tipo = :tipo;", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("tipo") String tipo, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipoHabi WHERE tipo = :tipo", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("tipo") String tipo);

}
