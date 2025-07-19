package com.xansa.DBconnect.dbconnect.Fragments;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Practices {
    @Id
    int id;
    String name , age;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Practices(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Practices() {
    }
}
