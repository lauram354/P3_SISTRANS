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

    @Query(value = "SELECT * FROM servHotel WHERE Hoteles_nombreHotel = :Hoteles_nombreHotel;", nativeQuery = true)
    serviciosHotel darServiosPorHotel(@Param("Hoteles_nombreHotel") Integer Hoteles_nombreHotel);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servHotel(Hoteles_nombreHotel, Servicios_idServicio) VALUES (:Hoteles_nombreHotel, :Servicios_idServicio)", nativeQuery = true)
    void insertarServicioHotel( @Param("Servicios_idServicio") Integer Servicios_idServicio, @Param("Hoteles_nombreHotel") String Hoteles_nombreHotel);

    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servHotel WHERE Hoteles_nombreHotel = :Hoteles_nombreHotel, Servicios_idServicio = :Servicios_idServicio", nativeQuery = true)
    void eliminarServicioHotel(@Param("Servicios_idServicio") Integer Servicios_idServicio, @Param("Hoteles_nombreHotel") String Hoteles_nombreHotel);
    

}
