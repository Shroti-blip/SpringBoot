package com.xansa.DBconnect.dbconnect.Fragments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentController {

    @GetMapping("/frag1")
    public String frag1(){
        return "ForFrag/homeFrag";
    }

    @GetMapping("/set")
    public String set(Model model){
        model.addAttribute("greet","Good Morning");
        return "ForFrag/homeFrag";
    }

    @GetMapping("/set2")
    public String set2(Model model){
        model.addAttribute("msg" , "This is a MSG");
        model.addAttribute("title" , "This is a Title");
        return "ForFrag/homeFrag";
    }
}
