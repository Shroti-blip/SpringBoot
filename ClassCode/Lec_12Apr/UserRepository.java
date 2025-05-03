package com.xansa.DBconnect.dbconnect.Lec_12Apr;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<users, Integer> {//define primary key (@id for id)
//crudRepo or jpaRepository you have to extends one of them
    // jpaRepo consist more function and method or etc. then crudRepo.

    /*
    *
    * In Spring Data JPA, interfaces like UserRepository help us avoid writing
     boilerplate code for database operations. Instead of manually writing queries
      (like insert, update, delete, find), we just extend Spring's built-in repository
     interfaces (CrudRepository, JpaRepository, etc.), and Spring automatically gives us
      those methods.
    *
    * */


    /*
    * ### So instead of writing:
    *
    * 1).SELECT * FROM users WHERE id = ?
        2).userRepository.findById(id);

      ## Concept	        Meaning
        Interface	        Lets Spring generate query methods for free (findAll, save, delete, etc.)
        users	            Entity class (linked to the database table)
        Integer	            Data type of the primary key (usually the id)

     * */
}
