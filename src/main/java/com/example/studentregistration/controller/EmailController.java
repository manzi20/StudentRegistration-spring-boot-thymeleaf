package com.example.studentregistration.controller;

import com.example.studentregistration.utils.EmailSenderUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.studentregistration.model.EmailDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/api/v1")
public class EmailController {




    @Autowired
    private EmailSenderUtil emailSenderUtil;





    @GetMapping("/av")
    public String listProduct(Model model) {
        model.addAttribute("emailDetails", new EmailDetails() );

        return "email-sender";
    }

    @PostMapping("/sendMail")
    public String OpenEmailServicePage(@ModelAttribute EmailDetails emailDetails,RedirectAttributes redirectAttributes){
        System.out.println(emailDetails.toString());
        String message= emailSenderUtil.sendEmail(emailDetails);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/api/v1/av";

    }

    @PostMapping("/attachment")
    public String sendEmailWithAttachment(@ModelAttribute EmailDetails emailDetails,RedirectAttributes redirectAttributes){


        String message= emailSenderUtil.sendEmailWithAttachment(emailDetails);

        redirectAttributes.addFlashAttribute("message", message);
        return"redirect:/api/v1/av";
    }


    // Sending a simple Email
//    @PostMapping(value = "/sendMail" ,  consumes = MediaType.APPLICATION_JSON_VALUE)
//    public String
//    sendMail(@RequestBody EmailDetails details , RedirectAttributes redirectAttributes)
//    {
//        String status
//                = emailService.sendSimpleMail(details);
//redirectAttributes.addFlashAttribute("message", status);
//        return "redirect: api/v1/av";
////        return status;
//    }
//
//
//
//    // Sending email with attachment
//    @PostMapping("/sendMailWithAttachment")
//    public String sendMailWithAttachment(
//            @RequestBody EmailDetails details)
//
//    {
//        String status
//                = emailService.sendMailWithAttachment(details);
//
//        return status;
//    }


}
