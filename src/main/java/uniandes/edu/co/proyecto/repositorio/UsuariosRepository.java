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
    Usuarios darUsuario(@Param("idUsuario") Integer idUsuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) VALUES (:idUsuario, :nombreUsuario, :email, :rol, :Hoteles_nombreHotel, :tipoId)", nativeQuery = true)
    void insertarUsuario(@Param("idUsuario") Integer idUsuario, @Param("nombreUsuario") String nombreUsuario, @Param("email") String email, @Param("rol") String rol, @Param("Hoteles_nombreHotel") String Hoteles_nombreHotel, @Param("tipoId") String tipoId);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE Usuarios SET tipoId = :tipoId, nombreUsuario = :nombreUsuario, email = :email, rol= :rol, Hoteles_nombreHotel = :Hoteles_nombreHotel WHERE idUsuario = :idUsuario", nativeQuery = true)
    void actualizarUsuario(@Param("idUsuario") Integer idUsuario, @Param("nombreUsuario") String nombreUsuario, @Param("email") String email, @Param("rol") String rol, @Param("Hoteles_nombreHotel") String Hoteles_nombreHotel, @Param("tipoId") String tipoId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuarios WHERE idUsuario = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") int id);

}
