package com.ndytar.aglycemie.services.serviceImple;

import com.ndytar.aglycemie.dto.UtulisateurDto;
import com.ndytar.aglycemie.exception.ErrorCodes;
import com.ndytar.aglycemie.exception.InvalidEntityException;
import com.ndytar.aglycemie.model.Roles;
import com.ndytar.aglycemie.repository.RolesRepository;
import com.ndytar.aglycemie.services.AccountService;
import com.ndytar.aglycemie.services.UtilisateurService;
import com.ndytar.aglycemie.validator.RoleValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class AccountServiceImpl implements AccountService {
  UtilisateurService utilisateurService;
  RolesRepository repository;
    
    public AccountServiceImpl(UtilisateurService utilisateurService, RolesRepository repository) {
        this.utilisateurService = utilisateurService;
        this.repository = repository;
    }
    
    @Override
    public void addRolToUser(String mail, String role) {
        UtulisateurDto appUser = utilisateurService.findUtilisateurByMail(mail);
        Roles roles = repository.findRolesByRolenom(role);
        appUser.getRoles().add(roles);
    }

    @Override
    public Roles addNewRole(Roles role) {
        List<String> errors = RoleValidator.validate(role);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("Le role n'est pas valide", ErrorCodes.ROLE_NOT_VALID, errors);
        }
       return repository.save(role);
    }

    @Override
    public List<Roles> listRoles() {
        return repository.findAll();
    }

}
