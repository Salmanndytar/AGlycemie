package com.ndytar.aglycemie.validator;

import com.ndytar.aglycemie.model.Roles;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {

    public static List<String> validate(Roles rolesDto){
        List<String> errors = new ArrayList<>();
        if (!StringUtils.hasLength(rolesDto.getRolenom()) || rolesDto.getRolenom() == null){
            errors.add("Veillez entrer le nom de role");
        }
        return  errors;
    }
    public static List<String> validateId(Roles rolesDto){
        List<String> errors = new ArrayList<>();
        if (rolesDto.getId()== null){
            errors.add("Veillez entrer id role");
        }
        return  errors;
    }
}
