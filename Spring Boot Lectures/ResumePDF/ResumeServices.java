package com.xansa.DBconnect.dbconnect.ResumePDF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeServices {

   @Autowired
    ResumeRepository resumeRepository;

   public Resume saveData(MultipartFile file) throws Exception{
       Resume resume = new Resume();
       resume.setName(file.getOriginalFilename());
       resume.setType(file.getContentType());
       resume.setData(file.getBytes());
       return resumeRepository.save(resume);
   }
}
