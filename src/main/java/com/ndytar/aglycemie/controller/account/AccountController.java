package com.ndytar.aglycemie.controller.account;

import com.ndytar.aglycemie.dto.RoleToUser;
import com.ndytar.aglycemie.model.Roles;
import com.ndytar.aglycemie.services.serviceImple.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController implements AccountApi {
    private AccountServiceImpl accountService;
    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }


    @Override
    public Roles saveRole(Roles appRole) {
        return accountService.addNewRole(appRole);
    }

    @Override
    public List<Roles> finAll() {
        return accountService.listRoles();
    }
    @Override
    public void roleToUser(RoleToUser roleToUser) {
        accountService.addRolToUser(roleToUser.getMail(),roleToUser.getRole());
    }
}
