package com.ndytar.aglycemie.services;

import com.ndytar.aglycemie.dto.AlimentDto;
import com.ndytar.aglycemie.dto.CategorieDto;
import com.ndytar.aglycemie.model.EtatAliment;

import java.util.List;

public interface AlimentService {
    AlimentDto save(AlimentDto alimentDto);
    AlimentDto finById(Integer id);
    List<AlimentDto> findAllbyCategorie(CategorieDto categorieDto);
    List<AlimentDto> finAll();
    void delete(Integer id);
    AlimentDto updateEtatAliment(Integer idAliment, String etatAliment);
    List<AlimentDto> findAllByEtatAliment(EtatAliment etatAliment);
}
