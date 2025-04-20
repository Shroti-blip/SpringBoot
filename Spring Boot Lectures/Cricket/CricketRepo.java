package com.shroti.personClass.Cricket;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CricketRepo extends CrudRepository<CricketEntity , Integer> {
    public List<CricketEntity> getByName(String name);// Select *from Cricketer where name='veer';
    public List<CricketEntity> getByTeam(String team);
}
