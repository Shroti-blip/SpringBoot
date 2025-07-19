package com.xansa.DBconnect.dbconnect.Fragments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeaderFooterController {

    @GetMapping("/getheader")
    public String getFrag(){
        return "ForFrag/headerfooterFrag";
    }

    @GetMapping("/setgreet")
    public String getgreet(Model model){
        model.addAttribute("greet" , "Good Morning guys.");
        return "ForFrag/headerfooterFrag";
    }

    @GetMapping("/setbody")
    public String getBody(Model model){
        model.addAttribute("name" , "Muskan Shroti");
        model.addAttribute("age" , "18");
        return "ForFrag/headerfooterFrag";
    }
}
