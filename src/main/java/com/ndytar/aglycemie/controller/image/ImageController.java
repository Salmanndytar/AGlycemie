package com.ndytar.aglycemie.controller.image;

import com.ndytar.aglycemie.services.ImageProcessingService;
import ij.ImageJ;
import ij.ImagePlus;
import ij.io.Opener;
import ij.process.ImageConverter;
import io.scif.Reader;
import io.scif.img.ImgIOException;
import io.scif.img.ImgOpener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import ij.ImagePlus;
import ij.io.Opener;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

import static com.ndytar.aglycemie.utils.Constant.API_ROOT;

@RequestMapping(API_ROOT+"/auth")
@RestController
public class ImageController {
ImageProcessingService imageProcessingService;
@Autowired
public ImageController(ImageProcessingService imageProcessingService) {
    this.imageProcessingService = imageProcessingService;
}

@PostMapping(value = "/loadImage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Double> uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
    
//    if (file == null || file.isEmpty()) {
//       // return ResponseEntity.badRequest().body(0);
//    }
//    InputStream inputStream = file.getInputStream(); // Obtenez l'InputStream du fichier
//
//    ImgOpener opener = new ImgOpener();
//    ImagePlus  imagePlus = null;
//    //imagePlus = opener.openImgs(String.valueOf(inputStream)).get(0).getImageMetadata();
//
//
//   imageProcessingService.calculateVolume(imagePlus);
   return null;// ResponseEntity.ok(imagePlus);
   
}

}
