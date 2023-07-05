package com.ndytar.aglycemie.services.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class PhotoModel {
    private InputStream photo;
    private String titre;
    private Integer id;
    private String context;


}