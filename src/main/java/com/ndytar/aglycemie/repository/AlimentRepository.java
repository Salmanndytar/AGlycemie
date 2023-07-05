package com.ndytar.aglycemie.repository;


import com.ndytar.aglycemie.model.Aliment;
import com.ndytar.aglycemie.model.Categorie;
import com.ndytar.aglycemie.model.EtatAliment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentRepository extends JpaRepository<Aliment,Integer> {

   List<Aliment> findAlimentsByCategorie(Categorie categorie );
   List<Aliment> findAlimentsByEtatAliment(EtatAliment etatAliment);


}
