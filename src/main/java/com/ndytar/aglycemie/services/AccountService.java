package com.ndytar.aglycemie.services;
import com.ndytar.aglycemie.model.Roles;

import java.util.List;

public interface AccountService {

    void addRolToUser(String userName, String roleName);
    Roles addNewRole(Roles role);
    List<Roles> listRoles();

}
