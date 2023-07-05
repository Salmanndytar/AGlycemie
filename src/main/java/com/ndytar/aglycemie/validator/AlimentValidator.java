package com.ndytar.aglycemie.validator;

import com.ndytar.aglycemie.dto.AlimentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AlimentValidator {

    public static List<String> validate(AlimentDto alimentDto){
        List<String> errors = new ArrayList<>();

        if (alimentDto == null){
            errors.add("Veillez saisir info aliement ");
        }
        if (!StringUtils.hasLength(alimentDto.getCodeAlim())){
            errors.add("Veillez entrer le code aliement");
        }

        if (
           (!StringUtils.hasLength(alimentDto.getChargeGly()) || alimentDto.getChargeGly() == null)
                ||
                ((!StringUtils.hasLength(alimentDto.getIndexGly()) ||alimentDto.getIndexGly()==null)
                &&
                (!StringUtils.hasLength(alimentDto.getContentGly()) ||alimentDto.getContentGly()==null))
        ){
            errors.add("Veillez entrer charge glycemique ou (contite glycemie et index glycemique)");
        }
        if (alimentDto.getCategorie()==null){
            errors.add("Veillez selectionner une categorie");
        }

        return  errors;
    }
    public static List<String> validateEtat(String etatAliment){
        List<String> errors = new ArrayList<>();

        if (etatAliment == null || !StringUtils.hasLength(etatAliment))
            errors.add("Veillez passer un etat");



        return  errors;
    }

}
