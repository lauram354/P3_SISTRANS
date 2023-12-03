package uniandes.edu.co.proyecto.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String>{

    List<Hotel> findByid(String id);
    
}
