package com.goutham.springboot.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kishorejavvaji on 2/16/17.
 * Used to perform database actions
 */
@Repository
public interface SpringRepositoryInterface extends CrudRepository<DTOEntity, Long> {

    //Need to know how this is implemented by Spring
    List<DTOEntity> findByFirstName(String firstName);
    

}







