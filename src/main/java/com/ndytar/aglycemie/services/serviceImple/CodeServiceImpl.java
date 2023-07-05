package com.ndytar.aglycemie.services.serviceImple;

import com.ndytar.aglycemie.dto.SendMailDto;
import com.ndytar.aglycemie.dto.ValidationCodeDto;
import com.ndytar.aglycemie.repository.UtilisateurRepository;
import com.ndytar.aglycemie.services.CodeService;
import com.ndytar.aglycemie.services.EmailService;
import com.ndytar.aglycemie.services.UtilisateurService;
import com.ndytar.aglycemie.utils.LocatTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.ndytar.aglycemie.config.CodeValidationConfig.valCode;
import static com.ndytar.aglycemie.config.CodeValidationConfig.valMail;
@Service
public class CodeServiceImpl implements CodeService {
SendMailDto sendMailDto =new SendMailDto();
UtilisateurRepository utilisateurRepository;
EmailService emailService;

@Autowired
public CodeServiceImpl(UtilisateurRepository utilisateurRepository,
                       EmailService emailService) {
    this.utilisateurRepository = utilisateurRepository;
    this.emailService = emailService;
}

@Override
    public ValidationCodeDto GeneratCodeValidation(String mail) {
        ValidationCodeDto code =new ValidationCodeDto();
        Random random = new Random();
        utilisateurRepository.findUtilisateurByMail(mail);
        
        code.setCodeValidation(String.valueOf(random.nextInt(987654 - 543210)+543210));
        sendMailDto.setObject("Code de validation\nNB:c'est code va expiré dans 30mn\"+ ");
        sendMailDto.setTo(mail);
        sendMailDto.setMessage(code.getCodeValidation());
        emailService.sendEmail(sendMailDto);
        valCode.put(sendMailDto.getMessage(), LocatTime.tim());
        valMail.put(sendMailDto.getMessage(),sendMailDto.getTo());
        
        return code;
        
    }

}
