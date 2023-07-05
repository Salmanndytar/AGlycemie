package com.ndytar.aglycemie.services.serviceImple;

import com.ndytar.aglycemie.dto.AlimentDto;
import com.ndytar.aglycemie.dto.CategorieDto;
import com.ndytar.aglycemie.exception.EntityNotFoundException;
import com.ndytar.aglycemie.exception.ErrorCodes;
import com.ndytar.aglycemie.exception.InvalidEntityException;
import com.ndytar.aglycemie.model.Aliment;
import com.ndytar.aglycemie.model.EtatAliment;
import com.ndytar.aglycemie.repository.AlimentRepository;
import com.ndytar.aglycemie.services.AlimentService;
import com.ndytar.aglycemie.validator.AlimentValidator;
import com.ndytar.aglycemie.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AlimentServiceImpl implements AlimentService {

    private AlimentRepository alimentRepository;


    @Autowired
    public AlimentServiceImpl(AlimentRepository alimentRepository){
        this.alimentRepository = alimentRepository;
    }
    @Override
    public AlimentDto save(AlimentDto alimentDto) {
        List<String> errors = AlimentValidator.validate(alimentDto);
        if (!errors.isEmpty()){
            log.error("L'aliment n'est pas valide"+alimentDto);
            throw new InvalidEntityException("L'aliment n'est pas valide", ErrorCodes.ALIMENT_NOT_VALID,errors);
        }

        alimentDto.setEtatAliment(EtatAliment.NO_VALIDE);//inialiser
        Aliment dto = alimentRepository.save(AlimentDto.toEntity(alimentDto));
        return AlimentDto.fromEntitie(dto);

    }

    @Override
    public AlimentDto finById(Integer id) {
        if (id==null){
            log.error("Aliment null");
            return null;
        }
        return alimentRepository.findById(id)
                .map(AlimentDto ::fromEntitie)
                .orElseThrow(
                        () -> new EntityNotFoundException("Aucun aliment dans la base avec id fournis",ErrorCodes.ALIMENT_NOT_FUOND)
                );
    }

    @Override
    public List<AlimentDto> findAllbyCategorie(CategorieDto categorieDto ) {
        List<String> errors = CategorieValidator.validateId(categorieDto);
        if (!errors.isEmpty()){
            //log.error("L'aliment n'est pas valide"+categorieDto);
          throw new InvalidEntityException("L'aliment de ce categorie n'existe pas", ErrorCodes.CATEGORIE_NOT_VALID,errors);
        }

        return alimentRepository.findAlimentsByCategorie(CategorieDto.toEntity(categorieDto)).stream()
               .map(AlimentDto::fromEntitie)
                .collect(Collectors.toList());


    }


    @Override
    public List<AlimentDto> finAll() {
        //log.info(" ******public List<AlimentDto> finAll()***vient etre executé");

        return alimentRepository.findAll().stream()
                .map(AlimentDto::fromEntitie)
                .collect(Collectors.toList());

    }
    @Override
    public List<AlimentDto> findAllByEtatAliment(EtatAliment etatAliment) {
        //log.info(" ******public List<AlimentDto> finAll()***vient etre executé");

        return alimentRepository.findAlimentsByEtatAliment(etatAliment).stream()
                .map(AlimentDto::fromEntitie)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("Categorie null");
            return;
        }
        alimentRepository.deleteById(id);

    }

    @Override
    public AlimentDto updateEtatAliment(Integer idAliment, String etatAliment) {
        AlimentDto alimentDto = finById(idAliment);
        alimentDto.setEtatAliment(EtatAliment.valueOf(etatAliment));


        return AlimentDto.fromEntitie(alimentRepository.save(AlimentDto.toEntity(alimentDto)));


    }
}
