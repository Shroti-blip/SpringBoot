package com.xansa.DBconnect.dbconnect.Validations.PracticeValidation;

import jakarta.validation.constraints.*;

public class Teachers {

//    @Size(min=20 , max=60)  //`@Size(min=20, max=60)` annotation is used for **strings, collections, maps, or arrays**,
    //so we cant user @Size annotation for int

    @Min(20)
    @Max(60)
//     @NotBlank(message = "age must be filled.")// cant use for int value . only for Strings.
    int age;

    @NotBlank(message="Name must be filled")
     @Size(min=4 , max=20)
    String name;

    @NotBlank(message = "Subject name must be filled")
    String subject;

    @Email(message="Invalid Email")
    String  email;

    public Teachers(int age, String name, String subject, String email) {
        this.age = age;
        this.name = name;
        this.subject = subject;
        this.email = email;
    }

    public Teachers() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
