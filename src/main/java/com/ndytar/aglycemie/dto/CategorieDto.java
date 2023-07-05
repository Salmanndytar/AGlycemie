package com.ndytar.aglycemie.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ndytar.aglycemie.model.Aliment;
import com.ndytar.aglycemie.model.Categorie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CategorieDto {
    private Integer id;
    private String code;
    private String nomCategorie;
    private String designation ;
    @JsonIgnore
    private List<Aliment> alimentsist;

    public static CategorieDto fromEntitie(Categorie categorie){
        if (categorie == null){
            // execept
            return null;
        }
        return CategorieDto.builder()
                .id(categorie.getId())
                .code(categorie.getCode())
                .nomCategorie(categorie.getNomCategorie())
                .designation(categorie.getDesignation()).build();
    }
    public static Categorie toEntity(CategorieDto categorieDto){
        if (categorieDto == null){
            // execept
            return null;

        }
        Categorie categorie=new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setNomCategorie(categorieDto.getNomCategorie());
        categorie.setCode(categorieDto.getCode());
        categorie.setDesignation(categorieDto.getDesignation());
        return categorie;
    }
}
