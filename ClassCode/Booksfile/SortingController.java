package com.xansa.DBconnect.dbconnect.Booksfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortingController {

    @Autowired
    BookRepo bookRepo;

    @GetMapping("/pagi")
    public Page<Books> get(@RequestParam(name="page" , defaultValue = "0")int page, @RequestParam(name="size" , defaultValue = "2") int size, @RequestParam(name="direction", defaultValue = "asc") String direction, @RequestParam(name="column" , defaultValue = "bookname") String orderby){
//name="column"  ---->> for browser
//String orderby ----->> for parameters
        Sort sort ;
       if(direction.equals("asc")){
           sort = Sort.by(Sort.Direction.ASC,orderby);
       }
       else{
           sort = Sort.by(Sort.Direction.DESC, orderby);
       }

        Pageable pageable = PageRequest.of(page, size,sort);
        return bookRepo.findAll(pageable);
    }
}
