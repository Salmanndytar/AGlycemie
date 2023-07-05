package com.ndytar.aglycemie.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Roles")
public class Roles extends AbstractEntity{
    /** pour eviter de  modifier en ajoutant null pandent la modification user
     * car une foie creer le rol et user et apres on arrribue les roles a user
     * il n'est pas possible d'attribuer le role pendant la reation de user car Usser et role sont en @ManyToMany
     * i.e , pour attribuer un ou plusieurs role a un user on perends iduser et idRole(s) et on associe dans une table appart
    ***/
    @Column(name = "rolenom",length = 30, updatable = false)
    private String rolenom;

}
