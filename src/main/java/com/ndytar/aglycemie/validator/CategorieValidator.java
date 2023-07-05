package com.ndytar.aglycemie.validator;

import com.ndytar.aglycemie.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategorieValidator {
    public static List<String> validate(CategorieDto categorieDto){
        List<String> errors = new ArrayList<>();
        if (!StringUtils.hasLength(categorieDto.getNomCategorie()) || categorieDto == null){
            errors.add("Veillez entrer nom categorie");
        }
        return  errors;
    }
    public static List<String> validateId(CategorieDto categorieDto){
        List<String> errors = new ArrayList<>();
        if (categorieDto.getId()== null ){
            errors.add("Veillez entrer identifiant Categorie");
        }
        return  errors;
    }
}
