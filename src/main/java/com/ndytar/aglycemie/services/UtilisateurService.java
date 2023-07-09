package com.ndytar.aglycemie.services;


import com.ndytar.aglycemie.dto.ChangerMotdePassUtilisateurDto;
import com.ndytar.aglycemie.dto.UtulisateurDto;

import java.util.List;


public interface UtilisateurService {
    UtulisateurDto findUtilisateurByMail(String mail);
    UtulisateurDto sav(UtulisateurDto utulisateurDto);

List<UtulisateurDto> searchUserByname(String kyword);
Boolean checkMail(String mail);
UtulisateurDto ChangetMotdePasseUtilisateurService(ChangerMotdePassUtilisateurDto dto);
UtulisateurDto findUtilisateurById(Integer id);
UtulisateurDto findUtilisateurByCode(String code);


}
