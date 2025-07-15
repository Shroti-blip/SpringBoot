
package com.shroti.Assignments.Assignment5;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class DoctorsController {

    @GetMapping("/getpage")
    public String getPage(Model model){
        model.addAttribute("doctorData" , new DoctorsEntity());
        return "DoctorsFile/doctors";
    }

    @Autowired
    DoctorsRepository doctorsRepository;
    @PostMapping("/savedata")
    public String saveData(@Valid @ModelAttribute("doctorData") DoctorsEntity doctorsEntity,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("BindingResult:");
            return "DoctorsFile/doctors";
        }
        else{

        doctorsRepository.save(doctorsEntity);
        return "DoctorsFile/confirm";

    }
        }
}
