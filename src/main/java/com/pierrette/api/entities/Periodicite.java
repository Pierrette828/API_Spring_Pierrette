package com.pierrette.api.entities;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Periodicite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idValidite;
    private String libelleValidite;

    @OneToMany(mappedBy = "periodicite")
    private List<Paiement> paiements;

    public String getLibelleValidite() {
        return libelleValidite;
    }

    public void setLibelleValidite(String libelleValidite) {
        this.libelleValidite = libelleValidite;
    }
}
