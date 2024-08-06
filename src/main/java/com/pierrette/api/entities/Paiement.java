package com.pierrette.api.entities;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaiement;
    private Date datePaiement;
    private Integer montant;

    @ManyToOne
    @JoinColumn(name = "idOperateur")
    private Operateur operateur;

    @ManyToOne
    @JoinColumn(name = "idPeriodicite")
    private Periodicite periodicite;

    @ManyToMany(mappedBy = "paiements1")
    private Set<Taxe> taxes = new HashSet<>();
}

