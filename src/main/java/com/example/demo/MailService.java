package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private JavaMailSender javaMailSender;


    public String sendMail(Employee employee) {
        employee = new Employee("395637649@qq.com","cgf123456789@aliyun.com",
                "用户登录账号密码！","parking_boy,123456");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(employee.getFrom());
        message.setTo(employee.getTo());
        message.setTo(employee.getTo());
        message.setSubject(employee.getSubject());
        message.setText(employee.getContent());
        try {
            javaMailSender.send(message);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }
        return "success";
    }
}
