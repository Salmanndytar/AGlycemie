package com.ndytar.aglycemie.repository;


import com.ndytar.aglycemie.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
   Optional<Categorie> findCategoriesByNomCategorie(String nomCategorie);





}
