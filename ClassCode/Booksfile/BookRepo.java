package com.xansa.DBconnect.dbconnect.Booksfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends JpaRepository<Books,Integer> {

}
