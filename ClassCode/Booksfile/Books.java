package com.xansa.DBconnect.dbconnect.Booksfile;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Books {
    @Id
    int bookno;//pk

    public Books(int bookno, String bookname) {
        this.bookno = bookno;
        this.bookname = bookname;
    }

    public Books() {
    }

    String bookname;

    public int getBookno() {
        return bookno;
    }

    public void setBookno(int bookno) {
        this.bookno = bookno;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
