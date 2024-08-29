package com.pierrette.api.entities;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCommune;
    private String libelleCommune;
    private String libellePrefecture;
    
    @OneToOne
    @JoinColumn(name = "idPrefecture", nullable = true)
    private Prefecture prefecture;

    // @ManyToOne
    // @JoinColumn(name = "idPrefecture")
    // private Prefecture prefecture;

    
}
