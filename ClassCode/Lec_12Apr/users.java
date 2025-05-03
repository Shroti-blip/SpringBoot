package com.xansa.DBconnect.dbconnect.Lec_12Apr;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.Id;

//same name as table
@Entity//mapping an entity
public class users {
    @Id //primary key.
    int id;
    String name;
    public users(int userid, String username) {
        this.id = userid;
        this.name = username;
    }

    public users() {

    }

    public int getUserid() {
        return id;
    }

    public void setUserid(int userid) {
        this.id = userid;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }
}
