package com.xansa.DBconnect.dbconnect.Fragments;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class Controller {
//String name , age;
    @GetMapping("/greet")
    public String setData(Model model ){
        model.addAttribute("name" , "Muskan");
        model.addAttribute("age", "18");
        return "greet";
    }

    @GetMapping("/formfrag")
    public String get(){
        return "form";
    }

}
