package com.shroti.Assignments.Assignment4;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="enquiries")
public class EnquiriesEntity {

    @Id
    int enquiry_id;

    String name ,  phone , subject , message , status;
    LocalDate  enquiry_date;

    public EnquiriesEntity() {
    }


    public EnquiriesEntity(int enquiry_id, String name, String phone, String subject, String message, String status, LocalDate enquiry_date) {
        this.enquiry_id = enquiry_id;
        this.name = name;
        this.phone = phone;
        this.subject = subject;
        this.message = message;
        this.status = status;
        this.enquiry_date = enquiry_date;
    }

    public int getEnquiry_id() {
        return enquiry_id;
    }

    public void setEnquiry_id(int enquiry_id) {
        this.enquiry_id = enquiry_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getEnquiry_date() {
        return enquiry_date;
    }

    public void setEnquiry_date(LocalDate enquiry_date) {
        this.enquiry_date = enquiry_date;
    }

}
