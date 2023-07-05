package com.ndytar.aglycemie.services.strategy;

import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
//
//@Service
public class StrategyPhotoContext {
//    private BeanFactory beanFactory;
//    private Strategy strategy;
//    @Setter
//    private  String context;
//    private  PhotoModel photoModel;
//
//
//    @Autowired
//    public StrategyPhotoContext(BeanFactory beanFactory,PhotoModel photoModel) {
//        this.beanFactory = beanFactory;
//        this.photoModel = photoModel;
//    }
//    //Cettemethode: Object savePhoto(String context, Integer id, InputStream photo, String titre)
//    // est intenciee depuit le controller
//    // La methode lui meme intecie d'autres classes qui implementent l'interface strategie
//    public Object savePhoto(String context, Integer id, InputStream photo, String titre) throws FlickrException {
//        determinContext(context);
//        return strategy.savePhoto(id,photo,titre);
//    }
//
//    //USAGE : Controller
//
//    public Object savePhoto2(Object object) throws FlickrException {
//        this.photoModel = (PhotoModel) object;
//        determinContext(photoModel.getContext());
//        return strategy.savePhoto2(photoModel);//le contenu de l'objet est limité au niveau de la class implementee.
//        //la methode savPhoto est creee dans l'interface Strategy et implementee dans
//        // SaveAlimentPhot et dans SaveUtilisateutPho
//        //La valeur de variable strategy depent de context
//        //si le context = aliment, ce comme si strategy = new SaveAlimentPhoto() mais
//        // cla demande une contructor afin d'accedr aux methode implementee.
//        //si le context = utilisateur, c'est comme si strategy = new SaveUtilisateurPhoto()
//        //strategy est une injection d'intence de classe = context
//    }
//    private void determinContext(String context){
//        final String namBean = context+"Photo";
//        switch (context){
//            case "aliment":
//
//               strategy = beanFactory.getBean(namBean,SaveAlimentPhoto.class);
//                //equivaut à une intenciation de SaveAlimentPhoto avec constructor
//                break;
//            case "utilisateur":
//                strategy = beanFactory.getBean(namBean,SaveUtilisateurPhoto.class);
//                break;
//            default: throw new InvalidOperationException("Erreur de l'enregistrement de photo d'aliment", ErrorCodes.OPERATION_INVALID);
//
//        }
//    }
}
