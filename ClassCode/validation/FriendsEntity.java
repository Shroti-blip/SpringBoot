package com.example.Practice11.validation;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "friends")
public class FriendsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotBlank
    String name;
    @NotNull
    String address;
    @Email
    String email;
    @Min(18)
    int age;
    @Pattern(regexp = "")
    String mno;
    @NotNull
    String nickname;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public FriendsEntity() {
    }

    public FriendsEntity(int id, String name, String address, String email, int age, String mno, String nickname) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
        this.mno = mno;
        this.nickname = nickname;
    }
}
