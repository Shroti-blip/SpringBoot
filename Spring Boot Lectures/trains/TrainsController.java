package com.xansa.DBconnect.dbconnect.trains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class TrainsController {
    @Autowired
    TrainsRepository trainsRepository;

    @GetMapping("/trains")
    public String trains(Model model){
        List<TrainsEntity> trainslist = trainsRepository.findAll();
        model.addAttribute("data" , trainslist);
        return  "Trains/trains";
    }

    @GetMapping("/search")
    public String Search(){
        return "Trains/search";
    }

    @GetMapping("/searchresult")
    public String searchresult(Model model, @RequestParam int tno, @RequestParam String source){
        List<TrainsEntity> filteredList = trainsRepository.findByTnoAndSourceIgnoreCase(tno , source);
        model.addAttribute("data" , filteredList);
        return "Trains/trains";
    }

    //01/05/2025

    @GetMapping("/updateTrains")
    public  String get(){
        return "Trains/update";
    }

    @PostMapping("/update")
    public String update(Model model, @RequestParam int tno , @RequestParam String tname, @RequestParam String source, @RequestParam String destination){
        TrainsEntity trains = trainsRepository.findById(tno).orElse(null);
        if(trains != null){
            trains.setTname(tname);
            trains.setSource(source);
            trains.setDestination(destination);
            trainsRepository.save(trains);
            model.addAttribute("message" , "Data Updated");
            return "Trains/update";
//           return("redirect:savedata.html");
        }
        else{
            model.addAttribute("errormessage" , "Train no. " + tno + " is Not Found.");
            return "error";
        }
    }
}
