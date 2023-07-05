package com.ndytar.aglycemie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Categorie")
public class Categorie extends AbstractEntity{

    @Column(name = "code",length = 30,unique = true)
    private String code;
    @Column(name = "nomCategorie",length = 100,unique = true)
    private String nomCategorie;

    @Column(name = "designation",length = 500)
    private String designation ;
   @JsonIgnore
   @OneToMany(mappedBy = "categorie")
    List<Aliment> alimentList;

}
