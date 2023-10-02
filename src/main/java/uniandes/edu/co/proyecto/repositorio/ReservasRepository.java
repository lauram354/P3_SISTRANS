package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional; 
import uniandes.edu.co.proyecto.modelo.Reservas;

public interface ReservasRepository extends JpaRepository<Reservas, Integer >{

    @Query(value = "SELECT * FROM reservas", nativeQuery=true)
    Collection<Reservas> darReservas();

    @Query(value = "SELECT * FROM reservas WHERE idReserva = :idReserva", nativeQuery = true)
    Reservas darReserva(@Param("idReserva") Integer idReserva);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas(IdReserva, NumPersonas, fechaInicial, fechaFinal, tipo) VALUES (:idReserva, :numPersonas, :fechaI, :fechaF, :tipo)", nativeQuery = true)
    void insertarReserva(@Param("idReserva") Integer idReserva, @Param("numPersonas") String numPersonas, @Param("fechaI") Date fechaI, @Param("fechaF") Date fechaF, @Param("tipo") String tipo);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET IdReserva = :idReserva, NumPersonas = :numPersonas, fechaInicial = :fechaI, fechaFinal = :fechaF, tipo = :tipo WHERE idReserva = :idReserva", nativeQuery = true)
    void actualizarReserva(@Param("idReserva") Integer idReserva, @Param("numPersonas") String numPersonas, @Param("fechaI") Date fechaI, @Param("fechaF") Date fechaF, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE idReserva = :idReserva", nativeQuery = true)
    void eliminarReserva(@Param("idReserva") Integer idReserva);
}