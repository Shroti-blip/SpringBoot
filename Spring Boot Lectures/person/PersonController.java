package com.shroti.personClass.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class PersonController {
    @Autowired
    personRepository personRepo;

    @RequestMapping("/form")
    public String getForm(){
        return "form";
    }

    @RequestMapping("/formfilled")
    public String formfilled(@RequestParam("name") String name, @RequestParam("address") String address , @RequestParam("state") String state, @RequestParam("dob")LocalDate dob, @RequestParam("gender") String gender){
    // formfilled has nothing to do with mapping formfilled.
        personsEntity pe = new personsEntity();
        pe.setName(name);
        pe.setAddress(address);
        pe.setState(state);
        pe.setDob(dob);
        pe.setGender(gender);
        personRepo.save(pe);
        return "redirect:/Confirmation.html";
        //return "save";
    }
}

