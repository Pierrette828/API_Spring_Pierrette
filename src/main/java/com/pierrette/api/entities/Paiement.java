package com.pierrette.api.entities;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaiement;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaiement;

    private Integer montant;

    @ManyToOne
    private Operateur operateur;

    @ManyToOne
    @JoinColumn(name = "idPeriodicite")
    private Periodicite periodicite;
    
    @PrePersist
    protected void onCreate() {
        this.datePaiement = new Date();
    }
}
