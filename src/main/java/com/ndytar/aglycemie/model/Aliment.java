package com.ndytar.aglycemie.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "Aliment")
public class Aliment extends AbstractEntity{
    @Column(name = "code",length =20, unique = true)
    private String codeAlim;

    @Column(name = "aliment",length =20)
    private String aliment;

    @Column(name = "index_gly",length =6)
    private String indexGly;

    @Column(name = "charge_gly",length =6)
    private String chargeGly;

    @Column(name = "content_gly",length =6)
    private String contentGly;

    @Column(name = "etat_aliment")
    private EtatAliment etatAliment;

    @Column(name = "photo")
    private String photo;

   @ManyToOne
   @JoinColumn(name = "idCategorie")
   private  Categorie categorie;

}
