package com.ndytar.aglycemie.services.serviceImple;

import com.ndytar.aglycemie.dto.AlimentDto;
import com.ndytar.aglycemie.dto.CategorieDto;
import com.ndytar.aglycemie.exception.EntityNotFoundException;
import com.ndytar.aglycemie.exception.ErrorCodes;
import com.ndytar.aglycemie.exception.InvalidEntityException;
import com.ndytar.aglycemie.exception.InvalidOperationException;
import com.ndytar.aglycemie.model.Categorie;
import com.ndytar.aglycemie.repository.CategorieRepository;
import com.ndytar.aglycemie.services.CategorieService;
import com.ndytar.aglycemie.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieImpl implements CategorieService {
    private CategorieRepository categorieRepository;

    @Autowired
    private AlimentServiceImpl alimentService;




    @Autowired
    public CategorieImpl(CategorieRepository categorieRepository){
        this.categorieRepository= categorieRepository;
    }
    @Override
    public CategorieDto sav(CategorieDto categorieDto) {
        List<String> errors = CategorieValidator.validate(categorieDto);
        if (!errors.isEmpty()){
            //log.error("Le categorie n'est pas valide"+categorieDto);
            throw new InvalidEntityException("Le gategorie n'est pas valide", ErrorCodes.CATEGORIE_NOT_VALID,errors);
        }
        Categorie saveCategorie = categorieRepository.save(CategorieDto.toEntity(categorieDto));
        return CategorieDto.fromEntitie(saveCategorie);
    }

    @Override
    public CategorieDto ctegorieFindBy(Integer id) {
        if (id==null){
            log.error("id Categorie null");
            return null;
        }


        return categorieRepository.findById(id)
                .map(CategorieDto ::fromEntitie)
                .orElseThrow(
                () -> new EntityNotFoundException("Aucun categorie dans la base avec id fournis",ErrorCodes.CATEGORIE_NOT_FUOND)
        );
    }

    @Override
    public CategorieDto ctegorieFinByNom(String nomCategorie) {
        if (!StringUtils.hasLength(nomCategorie)){
            log.error("Categorie null");
            return null;
        }

        return  categorieRepository.findCategoriesByNomCategorie(nomCategorie)
                .map(CategorieDto::fromEntitie)
                .orElseThrow(
                () ->new EntityNotFoundException("Aucun categorie de nom: "+nomCategorie,ErrorCodes.CATEGORIE_NOT_FUOND)
        );


    }


    @Override
    public List<CategorieDto> finAll() {
        return Optional.of(categorieRepository.findAll().stream()
                .map(CategorieDto::fromEntitie)
                .collect(Collectors.toList()))
                .orElseThrow(()->
                new EntityNotFoundException("Aucun categorie dans liste",ErrorCodes.CATEGORIE_NOT_FUOND));
//     return categorieRepository.findAll().stream()
//                .map(CategorieDto::fromEntitie)
//                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
         CategorieDto cat = ctegorieFindBy(id);
         List<AlimentDto> alimentDtos = alimentService.findAllbyCategorie(cat);
         if (!alimentDtos.isEmpty()){
             throw new InvalidOperationException("Impossible de supprimer car cette catgorie est utiliser par des aliment",ErrorCodes.OBJECT_UTILISE_AUTRE);
         }
      categorieRepository.deleteById(id);


    }
}
