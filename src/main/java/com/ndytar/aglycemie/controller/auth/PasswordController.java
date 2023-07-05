package com.ndytar.aglycemie.controller.auth;

import com.ndytar.aglycemie.dto.ChangerMotdePassUtilisateurDto;
import com.ndytar.aglycemie.dto.UtulisateurDto;
import com.ndytar.aglycemie.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ndytar.aglycemie.utils.Constant.API_ROOT;

@RestController
@RequestMapping(API_ROOT+"/auth")
public class PasswordController {
UtilisateurService utilisateurService;
@Autowired
public PasswordController(UtilisateurService utilisateurService)
{
    this.utilisateurService = utilisateurService;
}
@PostMapping(value = "/password", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

public ResponseEntity<UtulisateurDto> password(@RequestBody ChangerMotdePassUtilisateurDto pwdAndMail) {
    System.out.println("blaalalalal  controller password est appeler");
    System.out.println("********m**mm**mmmmmmail: "+pwdAndMail.getMail());
    System.out.println("passwor brute: "+pwdAndMail.getMotDepasse());
    return  ResponseEntity.ok(utilisateurService.ChangetMotdePasseUtilisateurService(pwdAndMail));
}
}
