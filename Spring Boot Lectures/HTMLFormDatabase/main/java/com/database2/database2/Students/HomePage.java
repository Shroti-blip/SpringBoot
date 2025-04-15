package com.database2.database2.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePage {
    @RequestMapping("/homepage")
    public String getPage(){
        return "homepage";
    }

    @Autowired
    StudentRepository studentRepository;
    @RequestMapping("/savedata")
    public String getSave(@RequestParam("id")int bno,@RequestParam("name")String name,@RequestParam("gender")String gender){
        Student student=new Student(bno,name,gender);
        studentRepository.save(student);
        return "redirect:/savedata.html";
    }
}
