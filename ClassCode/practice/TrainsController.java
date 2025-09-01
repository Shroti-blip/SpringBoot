package com.example.Practice11.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.filter.UrlHandlerFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TrainsController {


    @Autowired
    TrainsRepo trainsRepo;

    @GetMapping("/showall1")
    public String showAll(Model model){
        Iterable<TrainsEntity> trainsEntities = trainsRepo.findAll();
        List<TrainsEntity> trainsEntityList = new ArrayList<>();
        trainsEntities.forEach(trainsEntityList::add);
        model.addAttribute("trains" , trainsEntityList);
        return "showalldata";
    }

    //responseentity return type for returning data in json format.
    @GetMapping("/find/{id}")
    public ResponseEntity<TrainsEntity> getById(@PathVariable int id , Model model){
        return trainsRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//way 1 for printing in view/html page
    @GetMapping("/find2/{id}")
    public String getByID2(@PathVariable int id , Model model){
      TrainsEntity trainsEntity = trainsRepo.findById(id).orElse(null);
      model.addAttribute("data" , trainsEntity);
      return "showbyid";
    }

    //way 2
    @GetMapping("find3/{id}")
    public String getByID3(@PathVariable int id , Model model){
        Optional<TrainsEntity> optTrains = trainsRepo.findById(id);
        if(optTrains.isPresent()){
            TrainsEntity entity = optTrains.get();
            model.addAttribute("data" , entity);
        }
        return "showbyid";
    }

    //way 3
    @GetMapping("/find4/{id}")
    public String getByID4(@PathVariable int id , Model model){
        TrainsEntity trainsEntity = trainsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        model.addAttribute("data" , trainsEntity);
        return "showbyid";

    }
}
