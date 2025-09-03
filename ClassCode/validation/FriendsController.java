package com.example.Practice11.validation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FriendsController {

    @GetMapping("/validation")
    public String validForm(Model model){
        model.addAttribute("friendData" , new FriendsEntity());//binding html form
        return "FriendsInfo";
    }

    @PostMapping("/process")
    public String saveData(@Valid @ModelAttribute("friendData") FriendsEntity friendData , BindingResult result){

        if(result.hasErrors()){
            System.out.println("Not Done.");
            return "FriendsInfo";
        }
        else {
            System.out.println("Done.");
            System.out.println(friendData);
            return "confirmation";
        }
    }

}
