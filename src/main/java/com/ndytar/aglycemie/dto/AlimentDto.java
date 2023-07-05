package com.ndytar.aglycemie.dto;

import com.ndytar.aglycemie.model.Aliment;
import com.ndytar.aglycemie.model.Categorie;
import com.ndytar.aglycemie.model.EtatAliment;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class AlimentDto {
    private Integer id;
    private String codeAlim;

    private String aliment;

    private String indexGly;

    private String chargeGly;

    private String contentGly;
    private EtatAliment etatAliment;

    private String photo;

    private Categorie categorie;

    private Instant creationDate;

     private Instant lastModifiedDate;

    public static AlimentDto fromEntitie(Aliment aliment) {
        if (aliment.equals(null)){
            // execept
            return null;
        }
        return AlimentDto.builder()
                .id(aliment.getId())
                .aliment(aliment.getAliment())
                .etatAliment(aliment.getEtatAliment())
                .codeAlim(aliment.getCodeAlim())
                .indexGly(aliment.getIndexGly())
                .contentGly(aliment.getContentGly())
                .chargeGly(aliment.getChargeGly())
                .categorie(aliment.getCategorie())
                .photo(aliment.getPhoto())
                .creationDate(aliment.getCreationDate())
                .lastModifiedDate(aliment.getLastModifiedDate())
                .build();
    }
    public static Aliment toEntity(AlimentDto alimentDto){
        if (alimentDto.equals(null)){
            // execept
            return null;

        }
        Aliment aliment=new Aliment();
        aliment.setId(alimentDto.getId());
        aliment.setAliment(alimentDto.getAliment());
        aliment.setEtatAliment(alimentDto.getEtatAliment());
        aliment.setCodeAlim(alimentDto.getCodeAlim());
        aliment.setCategorie(alimentDto.getCategorie());
        aliment.setChargeGly(alimentDto.getChargeGly());
        aliment.setContentGly(alimentDto.getContentGly());
        aliment.setIndexGly(alimentDto.getIndexGly());
        aliment.setPhoto(alimentDto.getPhoto());
        //aliment.setCreationDate(alimentDto.getCreationDate());
       // aliment.setLastModifiedDate(alimentDto.getLastModifiedDate());

        return aliment;
    }
}
