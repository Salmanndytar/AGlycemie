package com.ndytar.aglycemie.services.serviceImple;
import com.ndytar.aglycemie.dto.ChangerMotdePassUtilisateurDto;
import com.ndytar.aglycemie.dto.UtulisateurDto;
import com.ndytar.aglycemie.exception.EntityNotFoundException;
import com.ndytar.aglycemie.exception.ErrorCodes;
import com.ndytar.aglycemie.exception.InvalidEntityException;
import com.ndytar.aglycemie.model.Utilisateur;
import com.ndytar.aglycemie.repository.UtilisateurRepository;
import com.ndytar.aglycemie.services.EmailService;
import com.ndytar.aglycemie.services.UtilisateurService;
import com.ndytar.aglycemie.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import static com.ndytar.aglycemie.config.WebSecurityConfig.passwordEncoder;


@Service
@Slf4j

public class UtilisateurImpl  implements UtilisateurService {

UtilisateurRepository utilisateurRepository;
//PasswordEncoder  passwordEncoder ;
EmailService emailService;


@Autowired
public UtilisateurImpl(UtilisateurRepository utilisateurRepository,
                       //,@Lazy PasswordEncoder  passwordEncoder,
                       EmailService emailService) {
    this.utilisateurRepository = utilisateurRepository;
    //  this.passwordEncoder = passwordEncoder;
    this.emailService = emailService;
}

@Override
public UtulisateurDto findUtilisateurByMail(String mail) {
    Utilisateur utilisateur = utilisateurRepository.findUtilisateurByMail(mail)
                                      .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur avec ce mail",
                                              ErrorCodes.UTILISATEURS_NOT_FUOND));
    return UtulisateurDto.fromEntity(utilisateur);
}

@Override
public UtulisateurDto sav(UtulisateurDto utulisateurDto) {
    
    
    List<String> errors = UtilisateurValidator.validate(utulisateurDto);
    if (!errors.isEmpty()) {
        log.error("Utilisateur saisie n'est pas valide" + utulisateurDto);
        throw new InvalidEntityException("L'user n'est pas valide", ErrorCodes.UTILISATEURS_NOT_VALID, errors);
    }
       utulisateurDto.setCode(newCodeUser());
    if (utulisateurDto.getMotDePasse() !=null)
        utulisateurDto.setMotDePasse(passwordEncoder().encode(utulisateurDto.getMotDePasse()));
    Utilisateur saveUser = utilisateurRepository.save(Objects.requireNonNull(UtulisateurDto.toEntity(utulisateurDto)));
    
    return UtulisateurDto.fromEntity(saveUser);
}

@Override
public List<UtulisateurDto> searchUserByname(String kyword) {
    return Optional.of(utilisateurRepository.searchUserByname(kyword).stream()
                               .map(UtulisateurDto::fromEntity)
                               .collect(Collectors.toList())).orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur",
            ErrorCodes.UTILISATEURS_NOT_FUOND));
}

@Override
public Boolean checkMail(String mail) {
    if (mail != null) {
        List<String> errors = UtilisateurValidator.chekMail(mail);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("L'user n'est pas valide", ErrorCodes.UTILISATEURS_NOT_VALID, errors);
        }
    }
    Utilisateur utilisateur = utilisateurRepository.findUtilisateurByMail(mail).orElseThrow(() ->
                                                                                                    new EntityNotFoundException("Aucun utilisateur avec ce mail", ErrorCodes.UTILISATEURS_NOT_FUOND));
    return utilisateur != null;
}

@Override
public UtulisateurDto ChangetMotdePasseUtilisateurService(ChangerMotdePassUtilisateurDto dto) {
    List<String> errors = UtilisateurValidator.validateChangePassword(dto);
    if (!errors.isEmpty()) {
        log.error("Information saisie pour changer le mot de passe n'est pas valide");
        throw new InvalidEntityException("Impossible de changer le mot de passe", ErrorCodes.UTILISATEURS_NOT_VALID, errors);
    }
    
    System.out.println("******password ende: " + passwordEncoder().encode(dto.getMotDepasse()));
    
    UtulisateurDto utulisateurDto = findUtilisateurByMail(dto.getMail());
    
    utulisateurDto.setMotDePasse(dto.getMotDepasse());
    return sav(utulisateurDto);
}

@Override
public UtulisateurDto findUtilisateurById(Integer id) {
    Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(id)
                                      .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur avec cet id",
                                              ErrorCodes.UTILISATEURS_NOT_FUOND));
    return UtulisateurDto.fromEntity(utilisateur);
}

@Override
public UtulisateurDto findUtilisateurByCode(String code) {
    return null;
}

String newCodeUser() {
    Random random = new Random();
    String newCode ;
    Object user  ;
    
   do {
        newCode = String.valueOf(random.nextInt(987654 - 543210) + 543210);
        user= utilisateurRepository.findUtilisateurByCode(newCode);
      
    }  while (user !=null);
    
    
    return newCode;
}
}