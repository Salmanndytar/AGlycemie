package com.ndytar.aglycemie.services.strategy;
;
import com.ndytar.aglycemie.dto.AlimentDto;
import com.ndytar.aglycemie.exception.ErrorCodes;
import com.ndytar.aglycemie.exception.InvalidOperationException;
import com.ndytar.aglycemie.services.AlimentService;
import com.ndytar.aglycemie.services.FlickrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
@Service("alimentPhoto")
public class SaveAlimentPhoto /*implements Strategy*/{
//
//    private FlickrService flickrService;
//    private AlimentService alimentService;
//    private  PhotoModel photoModel1;
//
//    @Autowired
//    public SaveAlimentPhoto(FlickrService flickrService, AlimentService alimentService,PhotoModel photoModel1) {
//        this.flickrService = flickrService;
//        this.alimentService = alimentService;
//        this.photoModel1 =photoModel1;
//    }
//
//    @Override
//    public Object savePhoto(Integer id, InputStream photo, String titre)  {
//        AlimentDto alimentDto = alimentService.finById(id);
//        String urlPhoto = flickrService.savePhoto(photo,titre);
//        if (!StringUtils.hasLength(urlPhoto)){
//            throw new InvalidOperationException("Erreur de l'enregistrement de photo d'aliment", ErrorCodes.OPERATION_INVALID);
//        }
//        alimentDto.setPhoto(urlPhoto);
//        return alimentService.save(alimentDto);
//    }
//
//    @Override
//    public Object savePhoto2(Object objet) {
//        photoModel1 = (PhotoModel) objet;//L'objet doit contenir tous les proprités de Photomode (au niveaucontroller)
//
//        AlimentDto alimentDto = alimentService.finById(photoModel1.getId());
//
//        String urlPhoto = flickrService.savePhoto2(photoModel1);
//        if (!StringUtils.hasLength(urlPhoto)) {
//            throw new InvalidOperationException("Erreur de l'enregistrement de photo d'utilisateur", ErrorCodes.OPERATION_INVALID);
//        }
//        alimentDto.setPhoto(urlPhoto);
//        return alimentService.save(alimentDto);
//
//    }
}
