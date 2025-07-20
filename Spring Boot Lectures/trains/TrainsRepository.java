package com.xansa.DBconnect.dbconnect.trains;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainsRepository extends JpaRepository<TrainsEntity , Integer> {
    List<TrainsEntity>findByTnoAndSourceIgnoreCase(int tno, String source);

    //6/05/2025
//alice--->> t is alice here.
    @Query("select t from TrainsEntity t")
    List<TrainsEntity> showAllList();

    @Query("select t from TrainsEntity t where t.source=:source")
    List<TrainsEntity> showAllTrainsBySource(String source);

//    List<TrainsEntity> showAllTrainsBySource( @Param("source)String source);--->>when name are different in table and in entity.

    @Query("select t from TrainsEntity t where t.destination=:destination")
    List<TrainsEntity> showAllListByDestination(String destination);

    @Modifying
    @Transactional
    @Query("update TrainsEntity t set t.source=:source where t.tno=:tno")
    void updateTrainsSource(int tno  , String source);

    @Modifying
    @Transactional
    @Query("delete TrainsEntity t where t.tno=:tno")
    void deleteTrainsSource(int tno);

//8/05/2025


}
