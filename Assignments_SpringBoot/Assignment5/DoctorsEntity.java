package com.shroti.Assignments.Assignment5;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
@Table(name = "doctors")
public class DoctorsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotBlank(message = "Name must be filled")
     private String name;
    @NotNull
    String specialisation;
    @NotNull
    LocalDate doj;
    @Column(name="residentdoctor")
    Boolean residentDoctor;

    @NotNull(message = "Must choose gender.")
    String gender;


    public DoctorsEntity(int id, String name, String specialisation, LocalDate doj, Boolean residentDoctor, String gender) {
        this.id = id;
        this.name = name;
        this.specialisation = specialisation;
        this.doj = doj;
        this.residentDoctor = residentDoctor;
        this.gender = gender;
    }

    public DoctorsEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public Boolean getResidentDoctor() {
        return residentDoctor;
    }

    public void setResidentDoctor(Boolean residentDoctor) {
        this.residentDoctor = residentDoctor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
