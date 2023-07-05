package com.ndytar.aglycemie.services.serviceImple;


import com.ndytar.aglycemie.dto.SendMailDto;
import com.ndytar.aglycemie.services.EmailService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

JavaMailSender  javaMailSender;
@Autowired
public EmailServiceImpl(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
}

@Override

    public JavaMailSender sendEmail(SendMailDto sendMailDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("agalycemie@gmail.com");
        simpleMailMessage.setTo(sendMailDto.getTo());
        simpleMailMessage.setSubject(sendMailDto.getObject());
        simpleMailMessage.setText(sendMailDto.getMessage());

        javaMailSender.send(simpleMailMessage);
        log.info(javaMailSender.toString());
        return  javaMailSender;
    }


}
