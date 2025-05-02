package com.shroti.Assignments.Assignment4;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class EnquiryController {
    @Autowired
    EnquiryRepository enquiryRepository;
    //

    @RequestMapping("get")
    public String get(){
        return "savedata";
    }
    @PostMapping("/save")

    public String addEnquiry(@RequestParam("enquiry_id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone,
                             @RequestParam("enquiry_date") LocalDate enquiry_date ,
                             @RequestParam("subject") String subject ,
                             @RequestParam("message") String message ,
                             @RequestParam("status") String status ){
        EnquiriesEntity enquiriesEntity = new EnquiriesEntity();
        enquiriesEntity.setEnquiry_id(id);
        enquiriesEntity.setName(name);
        enquiriesEntity.setPhone(phone);
        enquiriesEntity.setEnquiry_date(enquiry_date);
        enquiriesEntity.setMessage(message);
        enquiriesEntity.setStatus(status);
        enquiriesEntity.setSubject(subject);
        enquiryRepository.save(enquiriesEntity);
        return("redirect:/confirm.html");
    }


//    ===================================================================================


    //getAll Data

//    public List<EnquiriesEntity> getAll(){
//        return enquiryRepository.findAll();
//    }

@GetMapping("/getData")
    public String getData(Model model){
         List<EnquiriesEntity> lst = enquiryRepository.findAll();
         model.addAttribute("enquiryList" , lst);
         return "alldata";
    }

//=========================================================================================

//    get Filtered Data

    @GetMapping("/byid")// this mapping will open the browser page and those other mapping will show the data.
    public String getId(){
        return "filterdata";
    }

    @GetMapping("/id")
     public String getById(Model model ,@RequestParam int enquiry_id ){
        Optional<EnquiriesEntity> filterIDlist = enquiryRepository.findById(enquiry_id);
                model.addAttribute("data" , filterIDlist);
        return "filterdata";
    }

//    @GetMapping("/byname")
//    public String getName(){
//        return "filterdata";
//    }

    @GetMapping("/name")
    public  String getByName(Model model, @RequestParam String name){
        List<EnquiriesEntity> lstName = enquiryRepository.findByName(name);
        model.addAttribute("data" , lstName);
        return "filterdata";
    }

//    @GetMapping("/bystatus")
//    public String getstatus(){
//        return "filterdata";
//    }
    @GetMapping("/status")
    public String getByStatus(Model model , @RequestParam String status){
        List<EnquiriesEntity>lstStatus = enquiryRepository.findByStatus(status);
        model.addAttribute("data" , lstStatus);
        return "filterdata";
    }

}
