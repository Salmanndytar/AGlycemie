package com.ndytar.aglycemie.controller.auth;

import com.ndytar.aglycemie.dto.ValidationCodeDto;
import com.ndytar.aglycemie.services.UtilisateurService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ndytar.aglycemie.utils.Constant.API_ROOT;

@RestController
@RequestMapping(API_ROOT+"/auth")
public class ChekMailController {
UtilisateurService utilisateurService;
@Autowired
public ChekMailController(UtilisateurService utilisateurService) {
    this.utilisateurService = utilisateurService;
}

@GetMapping(value = "/chekMail/{mail}",produces = MediaType.APPLICATION_JSON_VALUE)
 boolean Chekmail(@PathVariable("mail") String mail){
    return utilisateurService.checkMail(mail);
}
}
