package com.xansa.Test.Project.Assignment1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentEntryController {
   List<Student> studentList = new ArrayList<>();
   @PostMapping
    @ResponseBody
    public boolean addStudent(@RequestBody Student stu){//
       studentList.add(stu);
       return true;
   }
    @GetMapping
    @ResponseBody
    public List<Student> getStudent(){
       return studentList;
    }

//    @GetMapping("/{id}")
//    @ResponseBody
//    public List<Student> getAllStudentById(@PathVariable int id){
//       return studentList;
//    }

    @GetMapping("/{id}")
    @ResponseBody
    public Student getAllStudent(@PathVariable int id){
//      return studentList.stream().filter(student -> student.getId() == id).collect(Collectors.toList());
       for(int i=0;i<studentList.size();i++){
           if(studentList.get(i).getId()==id){
               return studentList.get(i);
           }
       }
       return null;

   }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteStudent(@PathVariable int id){
       studentList.removeIf(studentList->studentList.getId()==id);
//       (parameter) -> { logic }
    }
}
