package com.example.studentregistration.utils;

import com.example.studentregistration.model.EmailDetails;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;


@Component
public class EmailSenderUtil {

    @Autowired
    private FileStorageUtils fileStorageUtils;

    public String sendEmail(EmailDetails emailDetails){
        try{
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(456);
            email.setAuthentication("manzipaci4@gmail.com","ckwnodjcuqbmxurs");
            email.setSSLOnConnect(true);
            email.setFrom("manzipaci4@gmail.com");
            email.setSubject(emailDetails.getSubject());
            email.setMsg(emailDetails.getMessage());
            email.addTo(emailDetails.getReceiver());
            email.send();
            return ("Email sent successfully");

        }catch (Exception ex){
            ex.printStackTrace();
            return ("Failed to send email");

        }
    }




    public String sendEmailWithAttachment(EmailDetails emailDetails){
        try{

            MultipartFile multipartFile =emailDetails.getImage();
            String storageFilePath = fileStorageUtils.storeFile(multipartFile);

            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(storageFilePath);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("sample Image");
            attachment.setName(multipartFile.getOriginalFilename());

            // Create the email message
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("setp.googlemail.com");
            email.setSmtpPort(456);
            email.setAuthentication("manzipaci4@gmail.com","ckwnodjcuqbmxurs");
            email.setSSLOnConnect(true);
            email.setFrom("manzipaci4@gmail.com");
            email.setSubject(emailDetails.getSubject());
            email.setMsg(emailDetails.getMessage());
            email.addTo(emailDetails.getReceiver());
            email.send();

            // add the attachment
            email.attach(attachment);

            // send the email
            email.send();
            Files.delete(new File(storageFilePath).toPath());

         return "email sent successfully!!";

        }catch (Exception ex){
            return "Email sending failled!!";
        }
    }
}
