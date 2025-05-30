package com.xansa.DBconnect.dbconnect.Validations.PracticeValidation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeachersController {

    @RequestMapping("/getpage")
    public String getpage(Model model){
        model.addAttribute("teacherData" , new Teachers());
        return "validation/teachers";
    }


    @PostMapping("/process2")
    public String saveData(@Valid @ModelAttribute("teacherData") Teachers teacherData , BindingResult result){

        if(result.hasErrors()){
            return "validation/teachers";
        }
        else{
            System.out.println(teacherData);
            return "success";
        }

    }



    /*

    @PostMapping("/process2")
    public String saveData(String name  , String subject , String experience , int age){
        Teachers teachers = new Teachers();
        teachers.setName(name);
        teachers.setAge(age);
        teachers.setExperience(experience);
        teachers.setSubject(subject);
        return "success";
    }

     */


}
