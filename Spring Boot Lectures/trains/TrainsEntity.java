package com.xansa.DBconnect.dbconnect.trains;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trains")
public class TrainsEntity {
    @Id
    int tno;
    String tname , source , destination;

    public TrainsEntity() {
    }

    public TrainsEntity(int tno, String tname, String source, String destination) {
        this.tno = tno;
        this.tname = tname;
        this.source = source;
        this.destination = destination;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
