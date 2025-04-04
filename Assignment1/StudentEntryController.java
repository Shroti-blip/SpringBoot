package com.xansa.Test.Project.Assignment1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentEntryController {
   List<Student> studentList = new ArrayList<>();
   @PostMapping
    @ResponseBody
    public boolean addStudent(@RequestBody Student stu){
       studentList.add(stu);
       return true;
   }
    @GetMapping
    @ResponseBody
    public List<Student> getStudent(){
       return studentList;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteStudent(@PathVariable int id){
       studentList.removeIf(studentList->studentList.getId()==id);
       //(parameter) -> { logic }
    }
}
