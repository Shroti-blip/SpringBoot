package com.xansa.DBconnect.dbconnect.ResumePDF;


import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.List;

@Controller
public class ResumeController {

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    ResumeServices resumeServices;

    @PostMapping("/uploaddata")
    public ResponseEntity<String > uploaddata(@RequestParam("file") MultipartFile file){
        try{
            resumeServices.saveData(file);
            return ResponseEntity.ok("Data Saved");
        }
        catch (Exception e){
            return  ResponseEntity.status(300).body("Error" + e.getMessage());
        }
    }

    @GetMapping("/showpdf/{id}")
    public  ResponseEntity<byte []> showpdf(@PathVariable int id){
        Resume resume = resumeRepository.findById(id).orElse(null);//repo obj create.
        if(resume == null){
           throw new RuntimeException("File not Found");
        }

        else{
            HttpHeaders headers = new HttpHeaders();
           headers.setContentType(MediaType.APPLICATION_PDF);
           headers.setContentDisposition(ContentDisposition.attachment().filename("doc.pdf").build());
          return  new ResponseEntity<>(resume.getData(), headers, HttpStatus.OK);
        }
    }

    /*
    *

    @GetMapping("/showpdf/{id}")
    public  ResponseEntity<byte []> showpdf(@PathVariable int id){
        Resume resume = resumeRepository.findById(id).orElse(null);//repo obj create.
        if(resume == null){
           throw new RuntimeException("File not Found");
        }
        else{
            return ResponseEntity.ok()
                    //header-->> meta tag
                    .header("content-type", "application/pdf")
//                    .header("Content-Disposition" , "inline;filename=\"document.pdf")
                    .header("Content-Disposition" , "attachment;filename=\"document.pdf")//for downloading instead of direct open
                    .body(resume.getData());
        }
    }
    *
    * */

    @GetMapping("/showall")
    public String getAllPdf(Model model){
        List<Resume> pdf = resumeRepository.findAll();
        model.addAttribute("data" , pdf);
        return "pdftable";
    }
}
