package com.ndytar.aglycemie.services.serviceImple;

//import com.almtprojectndytar.almtproject.services.FlickrService;
//import com.almtprojectndytar.almtproject.services.strategy.PhotoModel;
//import com.flickr4java.flickr.Flickr;
//import com.flickr4java.flickr.FlickrException;
//import com.flickr4java.flickr.REST;
//import com.flickr4java.flickr.RequestContext;
//import com.flickr4java.flickr.auth.Auth;
//import com.flickr4java.flickr.auth.Permission;
//import com.flickr4java.flickr.uploader.UploadMetaData;
import com.ndytar.aglycemie.services.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
@Slf4j
@Service
public class FlickrServiceImpl implements FlickrService {
//    @Value("${flickr.apiKey}")
//    private String apiKey;
//    @Value("${flickr.apiSecret}")
//    private String apiSecret;
//
//    @Value("${flickr.appKey}")
//    private String appKey;
//
//    @Value("${flickr.appSecret}")
//
//    private String appSecret;

//
//    @Override
//    public String savePhoto(InputStream photo, String title) throws FlickrException {
//
//        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
//        Auth auth = new Auth();
//        auth.setPermission(Permission.DELETE);
//        auth.setToken(appKey);
//        auth.setTokenSecret(appSecret);
//
//
//        RequestContext requestContext = RequestContext.getRequestContext();
//        requestContext.setAuth(auth);
//        flickr.setAuth(auth);
//
//        UploadMetaData uploadMetaData = new UploadMetaData();
//        uploadMetaData.setTitle(title);
//        String photoId = flickr.getUploader().upload(photo, uploadMetaData);
//        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
//    }
//
//    @Override
//    public String savePhoto2(Object objet) throws FlickrException {
//        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
//        Auth auth = new Auth();
//        auth.setPermission(Permission.DELETE);
//        auth.setToken(appKey);
//        auth.setTokenSecret(appSecret);
//
//
//        RequestContext requestContext = RequestContext.getRequestContext();
//        requestContext.setAuth(auth);
//        flickr.setAuth(auth);
//
//        UploadMetaData uploadMetaData = new UploadMetaData();
//        PhotoModel photoModel = (PhotoModel) objet;
//        uploadMetaData.setTitle(photoModel.getTitre());
//        String photoId = flickr.getUploader().upload(photoModel.getPhoto(), uploadMetaData);
//        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
//    }


}
