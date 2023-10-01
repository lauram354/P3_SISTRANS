package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.serviciosHotel;

public interface serviciosHotelRepository extends JpaRepository<serviciosHotel, Tuple>{

    @Query(value = "SELECT * FROM servHotel", nativeQuery=true)
    Collection<serviciosHotel> darServicios();

    @Query(value = "SELECT * FROM servHotel WHERE Hoteles_nombreHotel = Hoteles_nombreHotel;", nativeQuery = true)
    serviciosHotel darHabitacion(@Param("Hoteles_nombreHotel") Integer Hoteles_nombreHotel);

    /**
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Habitaciones(id, tv, minibar, cafetera, tipoHabi_tipo, Hoteles_nombreHotel) VALUES (Habitaciones_id_seq.nextval,:tv,:minibar,:cafetera, :tipoHabi_tipo, Hoteles_nombreHotel)", nativeQuery = true)
    void insertarHabitacion( @Param("tv") Boolean tv, @Param("minibar") Boolean minibar, @Param("cafetera") Boolean cafetera,
     @Param("tipoHabi_tipo") String tipoHabi_tipo, @Param("Hoteles_nombreHotel") String Hoteles_nombreHotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE Habitaciones SET tv = :tv, minibar = :minibar, cafetera = :cafetera, tipoHabi_tipo =  tipoHabi_tipo, Hoteles_nombreHotel = :Hoteles_nombreHotel  WHERE id =:id;", nativeQuery = true)
    void actualizarHabitacion(@Param("id") Integer id, @Param("tv") Boolean tv, @Param("minibar") Boolean minibar, @Param("cafetera") Boolean cafetera,
     @Param("tipoHabi_tipo") String tipoHabi_tipo, @Param("Hoteles_nombreHotel") String Hoteles_nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id") Integer id);
    */

}
