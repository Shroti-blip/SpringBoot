package com.naukriforsagar.NaukriForSagar.EmailServices;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;


    // Simple mail
    public void sendSimpleEmail(String to,String subject,String body) {

        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    // Mime Email
    public void sendHtmlEmail(String to,String subject,String htmlBody) throws Exception{
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom("veerlodhi54@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody,true);
        mailSender.send(message);
    }

    // Email Using HTML Page
    public void sendHtmlEmailWithAttachment(String to, String subject, String htmlBody, MultipartFile attachmentPath) throws Exception{
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom("contactjobsagar@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody,true);

     //   FileSystemResource file=new FileSystemResource(new File(attachmentPath));
        helper.addAttachment(attachmentPath.getOriginalFilename(),new ByteArrayResource(attachmentPath.getBytes()));
        mailSender.send(message);
    }
    // Email Using Image Path Page
    public void sendHtmlEmailWithAttachmentImagePath(String to, String subject, String htmlBody, String attachmentPath) throws Exception{
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom("contactjobsagar@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody,true);

        FileSystemResource file=new FileSystemResource(new File(attachmentPath));
        helper.addAttachment(file.getFilename(),file);
        mailSender.send(message);
    }


    // Email Using Inline
    public void sendHtmlEmailWithAttachmentImage(String to,String companyName) throws Exception{
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom("shrotimuskan@gmail.com");
        helper.setTo(to);
        helper.setSubject("Welcome to "+companyName);
        String htmlBody="Hi <span>User</span><br>"+
                        "<p>Thank you for registering with <span>"+companyName +"</span> We're excited to have you on board. Your account is ready, and we look forward to helping you make the most of our services.</p>"+
                        "<p>If you have any questions, feel free to reach out to us at <span>contactjobsagar@gmail.com</span></p>"+
                        "Welcome aboard!<br>" +
                        "<h3>"+companyName+"</h3>"+
                        "<h4>"+to+"</h4>";

        helper.setText(htmlBody,true);

//        ClassPathResource image=new ClassPathResource("static/Images/websitelogo.png");
//        helper.addInline("logoImage",image);
        mailSender.send(message);
    }
}
