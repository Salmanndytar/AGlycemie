package com.ndytar.aglycemie.services;

import com.ndytar.aglycemie.dto.CategorieDto;

import java.util.List;

public interface CategorieService {
    CategorieDto sav(CategorieDto categorieDto);

    CategorieDto ctegorieFindBy(Integer id);
    CategorieDto ctegorieFinByNom(String nom);
    List<CategorieDto> finAll();
    void delete(Integer id);
}
