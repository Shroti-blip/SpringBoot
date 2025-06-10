package com.naukriforsagar.NaukriForSagar.EmailServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/sendmail")
    @ResponseBody
    public  String sendMail(){
        emailService.sendSimpleEmail(
                "shrotimuskan@gmail.com",
                "Test Subject",
                "This is the body of the test email"
        );
        return "Email sent!";
    }

    @GetMapping("/send2mail")
    @ResponseBody
    public String send2Mail(){
        try {
            String htmlContent = "<h1>Welcome,</hr><b>contactjobsagar@gmail.com </b> </h1><p>This is our website email.</p>";
            emailService.sendHtmlEmail("hollybuddy.ts2206@gmail.com", "HTML Email Subject", htmlContent);
            return "Email Sent!";
        }
        catch(Exception e){
            System.out.println("Error is "+e);
        }
        return "";
    }

    @GetMapping("/getsendmail")
    @ResponseBody
    public String getSendMail(){
        try {
            emailService.sendHtmlEmailWithAttachmentImagePath(
                    "shrotimuskan@gmail.com",
                    "Test Subject",
                    "This is the body of the test email",
                    "C:\\Users\\Veersingh Lodhi\\Documents\\Hardware Management System\\Images\\websitelogo.png"
            );
            return "Email sent!";
        }catch(Exception e){
            e.printStackTrace();
            return "Error sending email: "+e.getMessage();
        }
    }


    @GetMapping("/getsendmailinline")
    @ResponseBody
    public String getSendMailInline(){
        try {
            emailService.sendHtmlEmailWithAttachmentImage("shrotimuskan@gmail.com" ,"");
            return "Email sent!";
        }catch(Exception e){
            e.printStackTrace();
            return "Error sending email: "+e.getMessage();
        }
    }



    @PostMapping("/getsendmailhtmlpage")
    @ResponseBody
    public String getSendMailHTMLPage(@RequestParam("file") MultipartFile file){
        try {
            System.out.println(file.getOriginalFilename());
            emailService.sendHtmlEmailWithAttachment(
                    "shrotimuskan@gmail.com",
                    "Test Subject",
                    "Attachment File Email",
                    file
            );
            return "Email sent!";
        }catch(Exception e){
            e.printStackTrace();
            return "Error sending email: "+e.getMessage();
        }
    }
    @GetMapping("/getcompletemailpage")
    public String getHtmlPage()
    {
        return "EmailFolder/sendcompleteemail";
    }

    @PostMapping("/getcompletemail")
    @ResponseBody
    public String getCompleteMail(@RequestParam String to,@RequestParam String subject,@RequestParam String content,@RequestParam MultipartFile file){
        try {
            emailService.sendHtmlEmailWithAttachment(to, subject, content, file);
            return "Mail sent";
        }catch(Exception e){
            e.printStackTrace();
            return "Error sending email: "+e.getMessage();
        }
    }

}
