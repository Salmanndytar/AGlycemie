package com.ndytar.aglycemie.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Utilisateur")
public class Utilisateur extends AbstractEntity{

    @Column(name = "nom",length = 100)
    private String nom;

    @Column(name = "prenom",length =100)
    private String prenom;

    @Column(name = "motdepasse")
    private String motDePasse;

    @Column(name = "photo")
    private  String photo;

    @Column(name = "mail")
    private  String mail;

    @Column(name = "tel",length =30)
    private String tel;
    
    @Column(name = "taille")
    private float taille;
    
    @Column(name = "poids")
    private float poids;
    
    @Column(name = "sexe")
    private String sexe;

    @Column(name = "etat")
    private Boolean etat;
    
    @Column(name = "code",updatable = false)
    private String code;
    
    @Column(name = "suivi")
    private Boolean suivi;
    
  


    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "Suivi",
            joinColumns = @JoinColumn(name = "diabetique"),
            inverseJoinColumns = @JoinColumn(name = "medecin"))
    private List<Utilisateur> utilisateurs;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles> roles = new ArrayList<>();



}
