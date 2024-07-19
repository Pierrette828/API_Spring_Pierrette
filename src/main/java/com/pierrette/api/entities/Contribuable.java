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
public class Contribuable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContribuable;;
    private String nom;
    private String prenom;
    private String adresse;
    private String typeActivite;

    @ManyToMany
    @JoinTable(
            name = "contribuable_taxe",
            joinColumns = @JoinColumn(name = "idContribuable"),
            inverseJoinColumns = @JoinColumn(name = "idTaxe")
    )
    private Set<Taxe> taxes=new HashSet<>();


}
