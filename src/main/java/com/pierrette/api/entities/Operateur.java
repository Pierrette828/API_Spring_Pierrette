package com.pierrette.api.entities;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Operateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOperateur;
    private String nom;
    private String prenom;
    private Integer telephone;
    private String sexe;
    private String password;
    private Byte piece_identite;

    @ManyToOne
    @JoinColumn(name = "idType_operateur")
    private Type_operateur typeOperateur;

    @OneToMany(mappedBy = "operateur")
    private List<Paiement> paiements;


}
