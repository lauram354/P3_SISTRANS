package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.PlanesDeConsumos;

public interface planesConsumoRepository extends JpaRepository<PlanesDeConsumos, String >{

    @Query(value = "SELECT * FROM PlanesConsum", nativeQuery=true)
    Collection<PlanesDeConsumos> darPlanesDeConsumos();

    @Query(value = "SELECT * FROM PlanesConsum WHERE tipo = :tipo", nativeQuery = true)
    PlanesDeConsumos darPlanConsumo(@Param("tipo") String tipo);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PlanesConsum(Tipo, descuento, dias, Hoteles_nombreHotel) VALUES (:tipo, :descuento, :dias, :Hoteles_nombreHotel)", nativeQuery = true)
    void insertarPlanConsumo(@Param("tipo") String tipo, @Param("descuento") Float descuento, @Param("dias") Integer dias,  @Param("Hoteles_nombreHotel") String Hoteles_nombreHotel);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE PlanesConsum SET Tipo = :tipo, descuento = :descuento, dias = :dias, Hoteles_nombreHotel = :Hoteles_nombreHotel WHERE Tipo = :tipoId", nativeQuery = true)
    void actualizarPlan(@Param("tipo") String tipo, @Param("descuento") Float descuento, @Param("dias") Integer dias,  @Param("Hoteles_nombreHotel") String Hoteles_nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PlanesConsum WHERE Tipo = :tipo", nativeQuery = true)
    void eliminarPlanConsumo(@Param("tipo") String tipo);
}