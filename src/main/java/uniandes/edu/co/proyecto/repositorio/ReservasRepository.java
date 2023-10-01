package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Reservas;

public interface ReservasRepository extends JpaRepository<Reservas, Integer>{

    //RF9 hace falta acualizar llegada al hotel
    //Toca colocar que estas operaciones solo recepcionista

    //Consultar la reserva hotel. Si check_in está en false, no ha llegado. Si check_in true y check_out está en false, no se ha ido.
    //Si check_in y check_ou en false, el cliente no ha llegado al hotel.
    @Query(value = "SELECT idReserva, numPersonas, fechaInicial, fechaFinal, id, tipo,  Habitaciones_id, check_in, check_out SELECT FROM Reservas", nativeQuery = true)
    Collection<Reservas> darReservas();

    @Query(value = "SELECT idReserva, numPersonas, fechaInicial, fechaFinal, id, tipo,  Habitaciones_id, check_in, check_out SELECT FROM Reservas WHERE idReserva= : idReserva", nativeQuery = true)
    Collection<Reservas> darReserva(@Param("idReserva") Integer idReserva);

    //Registrar llegada al hotel. 
    @Modifying
    @Transactional
    @Query(value = "UPDATE Reservas SET check_in = true WHERE idReserva= :idReserva", nativeQuery = true)
    void registrar_Check_in_Reserva(@Param("idReserva") Integer idReserva);

    //Borrar llegada al hotel.
    @Modifying
    @Transactional
    @Query(value = "UPDATE Reservas SET check_in = false WHERE idReserva= :idReserva", nativeQuery = true)
    void borar_Check_in_Reserva(@Param("idReserva") Integer idReserva);

    //RF11 hace falta acualizar salida al hotel 

    //Registrar salida del hotel. 
    @Modifying
    @Transactional
    @Query(value = "UPDATE Reservas SET check_out = true WHERE idReserva= :idReserva", nativeQuery = true)
    void registrar_Check_out_Reserva(@Param("idReserva") Integer idReserva);

    //Borrar salida del hotel.
    @Modifying
    @Transactional
    @Query(value = "UPDATE Reservas SET check_out = false WHERE idReserva= :idReserva", nativeQuery = true)
    void borar_Check_out_Reserva(@Param("idReserva") Integer idReserva);

}