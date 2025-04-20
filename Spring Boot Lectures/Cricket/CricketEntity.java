package com.shroti.personClass.Cricket;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name="cricketer")
public class CricketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name , team ,  retired , allrounder;
    LocalDate debut;

    public CricketEntity() {
    }

    public CricketEntity(int id, String name, String team, String retired, String allrounder, LocalDate debut) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.retired = retired;
        this.allrounder = allrounder;
        this.debut = debut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRetired() {
        return retired;
    }

    public void setRetired(String retired) {
        this.retired = retired;
    }

    public String getAllrounder() {
        return allrounder;
    }

    public void setAllrounder(String allrounder) {
        this.allrounder = allrounder;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }
}
