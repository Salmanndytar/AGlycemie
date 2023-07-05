package com.ndytar.aglycemie.validator;
import com.ndytar.aglycemie.dto.ChangerMotdePassUtilisateurDto;
import com.ndytar.aglycemie.dto.UtulisateurDto;
import com.ndytar.aglycemie.dto.ValidationCodeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
        public static List<String> validate(UtulisateurDto usrDto){
            List<String> errors = new ArrayList<>();

            if (usrDto == null || usrDto.equals(null)){
                errors.add("Veillez saisir info utilisateur ");
            }
            if (!StringUtils.hasLength(usrDto.getMail())){
                errors.add("Veillez entrer le Mail");
            } if (!usrDto.getMail().matches(".+@.+\\.[a-z]+")){
                errors.add("Mail incorrcte");
            }
            if (!StringUtils.hasLength(usrDto.getNom())){
                errors.add("Veillez entrer Nom");
            }
            if (!StringUtils.hasLength(usrDto.getPrenom())){
                errors.add("Veillez entrer prenom");
            }
            if (!StringUtils.hasLength(usrDto.getMotDePasse())){
                errors.add("Veillez entrer Mot de passe");
            }

            return  errors;
        }
         public static List<String> chekMail(String mail){
            List<String> errors = new ArrayList<>();
             if (!mail.matches(".+@.+\\.[a-z]+")){
                 errors.add("Mail incorrcte");
             }
             return errors ;
         }
    public static List<String> validateChangePassword(ChangerMotdePassUtilisateurDto usrDto){
        List<String> errors = new ArrayList<>();
     
        if (usrDto == null){
            errors.add("Veillez saisir info utilisateur ");
        }

        return  errors;
    }

}
