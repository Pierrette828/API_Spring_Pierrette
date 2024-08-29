package com.pierrette.api.entities;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePayement {
    //date_paiement, montant, id_operateur, id_periodicite
    @JsonProperty("date_paiement")
    private Instant datePaiement;
    private Integer montant;
    private Integer idOperateur;
    private Integer idPeriodicite;
}
