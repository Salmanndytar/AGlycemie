package com.ndytar.aglycemie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ndytar.aglycemie.model.Roles;
import com.ndytar.aglycemie.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Builder
@Data

public class UtulisateurDto {
    private Integer id;

    private String nom;

    private String prenom;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String motDePasse;

    private  String photo;

    private  String mail;

    private String tel;
    private float poids;
    private float taille;
    private String sexe;
    private Boolean etat;
    private String code;

    private Collection<Roles> roles = new ArrayList<>();
    public static UtulisateurDto fromEntity(Utilisateur usr){
        if(usr.equals(null)){
            // DOO exception
            return null;
        }
        return UtulisateurDto.builder()
                       .id(usr.getId())
                       .nom(usr.getNom())
                       .prenom(usr.getPrenom())
                       .tel(usr.getTel())
                       .mail(usr.getMail())
                       .photo(usr.getPhoto())
                       .motDePasse(usr.getMotDePasse())
                       .sexe(usr.getSexe())
                       .taille(usr.getTaille())
                       .poids(usr.getPoids())
                       .code(usr.getCode())
                       .etat(usr.getEtat())
                       .roles(usr.getRoles())
                .build();
    }
    public static Utilisateur toEntity(UtulisateurDto usrDao){
        if (usrDao.equals(null)) {
            //DOO throws exception
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(usrDao.getId());
        utilisateur.setNom(usrDao.getNom());
        utilisateur.setPrenom(usrDao.getPrenom());
        utilisateur.setTel(usrDao.getTel());
        utilisateur.setMail(usrDao.getMail());
        utilisateur.setPhoto(usrDao.getPhoto());
        utilisateur.setMotDePasse(usrDao.getMotDePasse());
        utilisateur.setRoles(usrDao.getRoles());
        utilisateur.setCode(usrDao.getCode());
        utilisateur.setSexe(usrDao.getSexe());
        utilisateur.setEtat(usrDao.getEtat());
        utilisateur.setPoids(usrDao.getPoids());
        utilisateur.setTaille(usrDao.getTaille());
        return utilisateur;
    }
}
