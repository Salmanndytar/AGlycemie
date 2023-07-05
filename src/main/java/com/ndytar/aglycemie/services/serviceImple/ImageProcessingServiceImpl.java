package com.ndytar.aglycemie.services.serviceImple;

import com.ndytar.aglycemie.services.ImageProcessingService;
import ij.ImagePlus;
import ij.plugin.filter.EDM;
import ij.process.ImageProcessor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

@Service
public class ImageProcessingServiceImpl implements ImageProcessingService {
@Override
public Double calculateVolume(ImagePlus image) {

// Obtenir l'ImageProcessor de l'ImagePlus
//        ImageProcessor ip = image.getProcessor();
//
//        // Segmenter l'objet d'intérêt dans l'image en utilisant un seuillage approprié
//        ip.threshold(127); // Utilisez un seuil adapté à votre image
//
//        // Calculer la carte de distance euclidienne
//
//
//        EDM edm = new EDM();
//        edm.setup("", image);
//        edm.run(ip);
//
//        // Calculer le volume en comptant le nombre de pixels blancs (objets segmentés)
//        double volume = 0;
//        byte[] pixels = (byte[]) ip.getPixels();
//
//
//        for (int i = 0; i < pixels.length; i++) {
//            if (pixels[i] != 0) {
//                volume++;
//            }
//        }
//
//
//        volume++;
//
//
//    return volume;

    return null;

    }
}