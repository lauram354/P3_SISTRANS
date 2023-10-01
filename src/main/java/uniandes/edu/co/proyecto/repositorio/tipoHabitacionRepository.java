package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.tipoHabitaciones;

public interface tipoHabitacionRepository extends JpaRepository<tipoHabitaciones, String>{
    
    @Query(value = "SELECT * FROM tipoHabi", nativeQuery=true)
    Collection<tipoHabitaciones> darTipoHabitaciones();

    @Query(value = "SELECT * FROM tipoHabi WHERE tipo= :tipoHabi", nativeQuery = true)
    tipoHabitaciones darTipoHabitacion(@Param("tipo") String tipo);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipoHabi(tipo, capacidad) VALUES (:tipo, :capacidad);", nativeQuery = true)
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
