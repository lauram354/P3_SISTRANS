package uniandes.edu.co.proyecto.repositorio;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Reservas;
import uniandes.edu.co.proyecto.modelo.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer >{
    
    //RF1
    @Query("SELECT DISTINCT rol FROM Usuarios")
    ArrayList<String> findDistinctRol();

    @Query(value = "SELECT tipoId, idUsuario, nombreUsuario, email, rol FROM Usuarios", nativeQuery=true)
    Collection<Usuarios> darUsuarios();

    //RF2
    @Query(value = "SELECT tipoId, idUsuario, nombreUsuario, email, rol FROM Usuarios WHERE idUsuario= :idUsuario", nativeQuery = true)
    Usuarios darUsuario(@Param("idUsuario") int idUsuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) VALUES (:idUsuario, :nombreUsuario, :email, :rol, :nombreHotel, :tipoId)", nativeQuery = true)
    void insertarUsuario(@Param("idUsuario") Integer idUsuario, @Param("nombreUsuario") String nombreUsuario, @Param("email") String email, @Param("rol") String rol, @Param("Hoteles_nombreHotel") String nombreHotel, @Param("tipoId") String tipoId);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE Usuarios SET tipoId = :tipoId, nombreUsuario = :nombreUsuario, email = :email, rol= :rol, Hoteles_nombreHotel = :nombreHotel WHERE idUsuario = :idUsuario", nativeQuery = true)
    void actualizarUsuario(@Param("idUsuario") Integer idUsuario, @Param("nombreUsuario") String nombreUsuario, @Param("email") String email, @Param("rol") String rol, @Param("Hoteles_nombreHotel") String nombreHotel, @Param("tipoId") String tipoId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuarios WHERE idUsuario = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") int id);

    //RF9 hace falta acualizar llegada al hotel
    //Toca colocar que estas operaciones solo recepcionista

    @Query(value = "SELECT idReserva, numPersonas, fechaInicial, fechaFinal, Habitaciones_id, tipo, idUsuario, check_in, check_out FROM Reservas", nativeQuery = true)
    Collection<Reservas> darReservas();

    //Consultar la reserva hotel. Si check_in está en false, no ha llegado. Si check_in true y check_out está en false, no se ha ido.
    //Si check_in y check_ou en false, el cliente no ha llegado al hotel.
    @Query(value = "SELECT idReserva, numPersonas, fechaInicial, fechaFinal, Habitaciones_id, tipo, idUsuario, check_in, check_out FROM Reservas WHERE idReserva= : idReserva", nativeQuery = true)
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

    //RF10 
    //Toca colocar que solo empleado
    //
    //

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
