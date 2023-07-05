package com.ndytar.aglycemie.repository;


import com.ndytar.aglycemie.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles findRolesByRolenom(String rolename);
}
