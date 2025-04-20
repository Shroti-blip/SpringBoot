package com.shroti.personClass.person;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="persons")
public class personsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//for serial  --->> we generate identity like 1 then 2 then 3 and so on....
    int pid;
    String name, address, state,gender;
    LocalDate dob;

    public personsEntity() {
    }

    public personsEntity(int pid, String name, String address, String state , LocalDate dob, String gender) {
        this.pid = pid;
        this.name = name;
        this.address = address;
        this.state = state;
        this.dob  = dob;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
