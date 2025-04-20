package com.shroti.personClass.Cricket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller

public class CricketController {
@RequestMapping("/cricket")
    public String xyz(){
    return  "cricketerForm";
}
@Autowired
    CricketRepo cricketrepo;
@RequestMapping("/savecricketer")
    public String saveData(@RequestParam("name") String name , @RequestParam("team") String team , @RequestParam(value = "retired", defaultValue = "no") String retired , @RequestParam("allrounder") String allrounder, @RequestParam("debut")LocalDate debut){
    CricketEntity ce = new CricketEntity();
    ce.setName(name);
    ce.setAllrounder(allrounder);
    ce.setDebut(debut);
    ce.setTeam(team);
    ce.setRetired(retired);
    cricketrepo.save(ce);
    return "redirect:/Confirmation.html";
}



}
