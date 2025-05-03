package com.xansa.DBconnect.dbconnect.Booksfile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homepage {
    @RequestMapping("/homepage")
    public String homepage(){
        return "homepage";//file name Homepage.html; not case-sensitive in file name.
    }

}
