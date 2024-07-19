package com.pierrette.api.entities;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Taxe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTaxe;
    private String libelleTaxe;

    @ManyToMany
    @JoinTable(
            name = "taxe_commune",
            joinColumns = @JoinColumn(name = "idTaxe"),
            inverseJoinColumns = @JoinColumn(name = "idCommune")
    )
    private Set<Commune> communes= new HashSet<>();

    @ManyToMany(mappedBy = "taxes")
    private Set<Contribuable> contribuables= new HashSet<>();

    @ManyToMany(mappedBy = "taxes")
    private Set<Paiement> paiements= new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "paiement_taxe",
            joinColumns = @JoinColumn(name = "idTaxe"),
            inverseJoinColumns = @JoinColumn(name = "idPaiement")
    )
    private Set<Paiement> paiements1 = new HashSet<>();

    public void setIdTaxe(Integer idTaxe) {
        this.idTaxe=idTaxe;
    }
}
