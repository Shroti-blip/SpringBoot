package com.xansa.DBconnect.dbconnect.Booksfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    BookRepo bookre;

    @RequestMapping("/savedata")
    public String savedata(@RequestParam ("id") int bookno  , @RequestParam("bname") String bname){
        Books b = new Books();
        b.setBookname(bname);
        b.setBookno(bookno);
        bookre.save(b);
        return "redirect:/Confirmation.html";
    }

}
