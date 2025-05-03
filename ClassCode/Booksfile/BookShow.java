package com.xansa.DBconnect.dbconnect.Booksfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Controller//  return json
@RestController//return view

@RequestMapping("/bookshow")
public class BookShow {
    @Autowired
    BookRepo bookRepo;

//    @GetMapping
    @GetMapping("/uiform1")
//    public List<Books> getData(){//
    public String getData(Model model){

        List<Books> lst = bookRepo.findAll();//value store in var
        model.addAttribute("booklist" , lst);// booklist store lst data
        return "bookhtml";
//        return bookRepo.findAll();
    }

    @GetMapping("/orderBy")
    public List<Books> orderBy() {
        return bookRepo.findAll(Sort.by(Sort.Direction.DESC, "bookno"));
    }
    //sorting by user input like name , id , price
    @GetMapping("/orderBy/{col}")
    public List<Books> orderBy(@PathVariable String col) {
        return bookRepo.findAll(Sort.by(Sort.Direction.DESC, col));
       }

       

        @GetMapping("/pagination")
        public Page<Books>pagination(@RequestParam(name="page",defaultValue = "0") int page , @RequestParam(name="size",defaultValue = "2")int size)
        {
            Pageable pageable = PageRequest.of(page , size);
            return bookRepo.findAll(pageable);
        }






        //userinput
//    public List<Books> orderByUi(){
//    System.out.println("enter name: ");
//    String na = sc.next();
//        return bookRepo.findAll(Sort.by(Sort.Direction.ASC ,na));
//    }


//    @GetMapping("/orderByasc")
//    public List<Books> orderByasc(){
//        Sort sort = Sort.by(Sort.Direction.ASC , "bookname");
//        return bookRepo.findAll(sort);
//    }//bookname is same here as table name if not then have to write the variable name of entity class.
//
//}
    }