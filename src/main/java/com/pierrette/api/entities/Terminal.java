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
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTpe;
    private String model;

    @ManyToMany
    @JoinTable(
            name = "localisation_terminal",
            joinColumns = @JoinColumn(name = "idTpe"),
            inverseJoinColumns = @JoinColumn(name = "idLocalisation")
    )
    private Set<Localisation> localisations=new HashSet<>();

    @OneToOne()
    private Operateur operateur;

}
