/*
*
*
 //application properties code for connectivity
 spring.datasource.url = jdbc:postgresql://localhost:5432/postgres
 spring.datasource.username = postgres
 pring.datasource.password = manager



*
 // users.java is same name as the table name in pgadmin (postgres) server.
     1) create setter getter and default constructor
      2) use @Entity tag for //mapping an entity and @Id tag for Primary key
*
*
* /// UserRepository is an interface which is for extending CrudRepository

    public interface UserRepository extends CrudRepository<users, Integer> {//define primary key (@id for id)
   /##/crudRepo or jpaRepository you have to extends one of them
    // jpaRepo consist more function and method or etc. then crudRepo.
}



*
*
*
* */