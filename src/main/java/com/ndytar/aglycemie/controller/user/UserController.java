package com.ndytar.aglycemie.controller.user;

import com.ndytar.aglycemie.dto.UtulisateurDto;
import com.ndytar.aglycemie.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class UserController implements UserApi {
UtilisateurService utilisateurService;

@Autowired
public UserController(UtilisateurService utilisateurService) {
    this.utilisateurService = utilisateurService;
}

@Override
public UtulisateurDto findUtilisateurByMail(String mail) {
    
    return utilisateurService.findUtilisateurByMail(mail);
}

@Override
public UtulisateurDto findUtilisateurById(Integer id) {
    return utilisateurService.findUtilisateurById(id);
}

@Override
public UtulisateurDto sav(UtulisateurDto utulisateurDto) {
    return utilisateurService.sav(utulisateurDto);
}

@Override
public List<UtulisateurDto> findUtilisateurByNomContains(String kyword) {
    return utilisateurService.searchUserByname("%" + kyword + "%");
}


}