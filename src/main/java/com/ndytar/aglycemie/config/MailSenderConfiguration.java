package com.ndytar.aglycemie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailSenderConfiguration {



   @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);//25, 465, 587 ou 2525
        javaMailSender.setUsername("agalycemie@gmail.com");
        javaMailSender.setPassword("nsnawnomnznhllbw");


        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust","*");
        props.put("mail.smtp.tls","true");
        props.put("mail.smtp.connectiontimeout", 180000);//délais d'expiration des connexions SMTP est de 180000 (180 secondes) par daefaut infini
        props.put("mail.smtp.timeout", 70000);
        props.put("mail.smtp.writetimeout", 180000);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return javaMailSender;
    }
}
