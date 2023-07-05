package com.ndytar.aglycemie.services;

import com.ndytar.aglycemie.dto.ValidationCodeDto;

public interface CodeService {
ValidationCodeDto GeneratCodeValidation(String mail);

}
