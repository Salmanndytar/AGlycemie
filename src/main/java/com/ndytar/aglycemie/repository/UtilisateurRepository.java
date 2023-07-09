package com.ndytar.aglycemie.repository;
import com.ndytar.aglycemie.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
  Optional<Utilisateur> findUtilisateurByMail(String mail);
  Optional<Utilisateur> findUtilisateurById(Integer id);
 Object  findUtilisateurByCode(String code);
@Query("select c from Utilisateur c where c.nom like :ky")
List<Utilisateur> searchUserByname(@Param("ky") String kyword);
}
