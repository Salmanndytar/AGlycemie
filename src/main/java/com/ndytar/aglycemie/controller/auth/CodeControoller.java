package com.ndytar.aglycemie.controller.auth;

import com.ndytar.aglycemie.dto.UtulisateurDto;
import com.ndytar.aglycemie.dto.ValidationCodeDto;
import com.ndytar.aglycemie.services.CodeService;
import com.ndytar.aglycemie.services.UtilisateurService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ndytar.aglycemie.config.CodeValidationConfig.valCode;
import static com.ndytar.aglycemie.config.CodeValidationConfig.valMail;
import static com.ndytar.aglycemie.utils.Constant.API_ROOT;

@RestController
@RequestMapping(API_ROOT+"/auth")
public class CodeControoller {

CodeService codeService;
UtilisateurService utilisateurService;
@Autowired
public CodeControoller(CodeService codeService, UtilisateurService utilisateurService) {
    this.codeService = codeService;
    this.utilisateurService = utilisateurService;
}

@GetMapping(value = "/genereCode/{mail}",produces = MediaType.APPLICATION_JSON_VALUE)
ResponseEntity<ValidationCodeDto> GeneratCodeValidation(@PathVariable("mail") String mail){
   
    return ResponseEntity.ok(codeService.GeneratCodeValidation(mail));
}
@GetMapping("/validerCode/{code},{mail}")
public Boolean code(@PathVariable String code,String mail) {

//        System.out.println("Mail user: "+ utilisateurService.findUtilisateurByMail(mail).getMail());
//        System.out.println("code user: "+code);
//        for (Map.Entry mapentry : valMail.entrySet()) {
//            System.out.println("MailClé: " + mapentry.getKey() + " | MailValeur: " + mapentry.getValue());
//        }
//        for (Map.Entry mapentry : valCode.entrySet()) {
//            System.out.println("CodeClé: " + mapentry.getKey() + " | CodeValeur: " + mapentry.getValue());
//        }
    UtulisateurDto usr =  utilisateurService.findUtilisateurByMail(mail);
    if (valCode.containsKey(code) && valMail.containsValue(usr.getMail())){
        usr.setEtat(true);
        utilisateurService.sav(usr);
        return true;
    }
    return false;
}
}
