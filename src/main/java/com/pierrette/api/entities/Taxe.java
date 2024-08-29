package com.pierrette.api.entities;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

//     @ManyToMany(mappedBy = "taxes")
//     private Set<Paiement> paiements= new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "paiement_taxe",
            joinColumns = @JoinColumn(name = "idTaxe"),
            inverseJoinColumns = @JoinColumn(name = "idPaiement")
    )
    private Set<Paiement> paiements1 = new HashSet<>();    

}
