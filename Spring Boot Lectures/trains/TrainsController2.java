package com.xansa.DBconnect.dbconnect.trains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TrainsController2 {
@Autowired
TrainsRepository trainsRepository;

@GetMapping("/getalltrains")
    public String alltrains(Model model){
    List<TrainsEntity> trainlst = trainsRepository.findAll();
    model.addAttribute("data" , trainlst);
    return "Trains/alltrains";
}

//==================================================================================

    //jpql-------->>>not on table , on Entity (operation perform).

    @GetMapping("/jp1")
    public String jp1(Model model){
    List<TrainsEntity> list = trainsRepository.showAllList();
    model.addAttribute("data", list);
    return "Trains/alltrains";//view.
    }

    @GetMapping("/jp2/{source}")
    public String jp2(Model model , @PathVariable String source){
    List<TrainsEntity> list = trainsRepository.showAllTrainsBySource(source);
    model.addAttribute("data", list);
    return "Trains/alltrains";
    }

    @GetMapping("/jp3/{destination}")
    public String jp3(Model model, @PathVariable String destination){
    List<TrainsEntity> list =trainsRepository.showAllListByDestination(destination);
    model.addAttribute("data", list);
    return "Trains/alltrains";
    }


    @GetMapping("/jp4/{tno}/{source}")
    @ResponseBody
    public void jp4(@PathVariable int tno, @PathVariable String source){
    trainsRepository.updateTrainsSource(tno, source);
    }
    @GetMapping("/jp5/{tno}")
    @ResponseBody
    public void jp5(@PathVariable int tno){
    trainsRepository.deleteTrainsSource(tno );
    }
    /*
    *
         @GetMapping("/jp4/{tno}/{source}")
    @ResponseBody
    public void jp4(@PathVariable int tno, @PathVariable String source){
    trainsRepository.updateTrainsSource(tno, source);
    }
    * */

//    @GetMapping("/jp2")
//    public String jp2(Model model){
//        List<TrainsEntity> list = trainsRepository.showAllTrainsBySource("Bhopal");
//        model.addAttribute("data", list);
//        return "alltrains";
//    }
//====================================================================================

@GetMapping("/currenttrain/{id}")
    public String currenttrainData(@PathVariable int id , Model model){
    TrainsEntity trains = trainsRepository.findById(id).orElse(null);
    if(trains != null){
        model.addAttribute("data" , trains);
        return "Trains/currenttrain";
    }
    else {
        return "Data Not Found";
    }
    }

    //=============================================================================

    @PostMapping("/update2")
    public  String updatetrains(Model model,  @RequestParam int tno , @RequestParam String tname , @RequestParam String source , @RequestParam String destination){
    TrainsEntity trainsEntity = trainsRepository.findById(tno).orElse(null);
    if(trainsEntity != null){
        trainsEntity.setTname(tname);
        trainsEntity.setSource(source);
        trainsEntity.setDestination(destination);
        trainsRepository.save(trainsEntity);
        Optional<TrainsEntity> trainsEntityList = trainsRepository.findById(tno);
        model.addAttribute("data2",trainsEntityList);
        return "Trains/currenttrain";
    }
    else{
        return null;
    }
    }





}
