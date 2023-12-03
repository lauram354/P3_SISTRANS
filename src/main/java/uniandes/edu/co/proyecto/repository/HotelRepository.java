package uniandes.edu.co.proyecto.repository;


import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, ObjectId>{

    //List<Hotel> findByInicio(String inicio);

    @Query("{}")
    List<Hotel> findAllHoteles();

}
