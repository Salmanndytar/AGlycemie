package com.ndytar.aglycemie.services;


import com.ndytar.aglycemie.dto.SendMailDto;
import org.springframework.mail.javamail.JavaMailSender;

public interface EmailService {
    JavaMailSender sendEmail(SendMailDto sendMailDto);
}
