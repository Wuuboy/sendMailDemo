package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MailService mailService;
    /**
     * @param employee String to, String from, String subject, String content
     * @return String
     */
    @GetMapping("/sendMail")
    public String sendMail(@RequestBody Employee employee) {
        return mailService.sendMail(employee);
    }
}
