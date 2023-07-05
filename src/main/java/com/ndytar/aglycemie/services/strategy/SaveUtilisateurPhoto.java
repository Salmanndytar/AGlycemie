package com.ndytar.aglycemie.services.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
@Slf4j
@Service("utilisateurPhoto")
public class SaveUtilisateurPhoto/* implements Strategy*/{
//
//    private FlickrService flickrService;
//    private UtilisateurService utilisateurService;
//    private  PhotoModel photoModel1;
//
//
//    @Autowired
//    public SaveUtilisateurPhoto(FlickrService flickrService, UtilisateurService utilisateurService,PhotoModel photoModel1) {
//        this.flickrService = flickrService;
//        this.utilisateurService = utilisateurService;
//        this.photoModel1 = photoModel1;
//    }
//
//    @Override
//    public Object savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
//        UtulisateurDto utulisateurDto = utilisateurService.finById(id);
//        String urlPhoto = flickrService.savePhoto(photo,titre);
//        if (!StringUtils.hasLength(urlPhoto)){
//            throw new InvalidOperationException("Erreur de l'enregistrement de photo d'utilisateur", ErrorCodes.OPERATION_INVALID);
//        }
//        utulisateurDto.setPhoto(urlPhoto);
//        return utilisateurService.sav(utulisateurDto);
//    }
//// Il est possible de creer des classes(tables) avce des structures differentes
//    //et implementer une seul interface dont les methodes passent en paramettre
//    //des objets
//    //***
//    // Une fois la classe implemente cette interface, elle va caster le l'objet son propre type
//    // ici l'objet est caster en:  photoModel1 = (PhotoModel) objet;
//    // La classe PhotoModel doit regrouper toutes les attribut de toutes les classes qui devons
//    // implementer une seule interface, comme ça quant on appel la methode de cette interface
//    // on va lui passer en âramettre un objet dont les proprietés sont independentes
//    //exemple ici ci dessus la methode savePhoto() a trois parametre pour enregistre une image
//    //avec id de l'user
//    //Parcontre la methode savePhoto2() qui est definie dans meme interface a pour parametre un
//    //objet, dans la methode savePhoto2() dont ici ci-dessous nous avons
//    // caster l'objet avec une classe PhotoModel qui ne contient pas id user comme se figure
//    // dans dans la methode savePhoto() ci-dessus. Au niveau de PhotoModel y pas id user mais
//    // contre on a ajouter un types de proprité qui User lui meme
//
//    @Override //USAGE : StrategyPhotoContext
//    public Object savePhoto2(Object objet) throws FlickrException {
//        this.photoModel1 = (PhotoModel) objet;//L'objet doit contenir tous les proprités de Photomode (au niveaucontroller)
//
//        UtulisateurDto utulisateurDto = utilisateurService.finById(photoModel1.getId());
//
//        String urlPhoto = flickrService.savePhoto2(photoModel1);
//        if (!StringUtils.hasLength(urlPhoto)) {
//            throw new InvalidOperationException("Erreur de l'enregistrement de photo d'utilisateur", ErrorCodes.OPERATION_INVALID);
//        }
//        utulisateurDto.setPhoto(urlPhoto);
//        return utilisateurService.sav(utulisateurDto);
//
//    }
}
