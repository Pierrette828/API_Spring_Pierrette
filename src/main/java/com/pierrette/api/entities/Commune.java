package com.pierrette.api.entities;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import java.util.HashSet;

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

    @ManyToOne
    @JoinColumn(name = "idPrefecture")
    private Prefecture prefecture;

    @ManyToMany(mappedBy = "communes")
    private Set<Taxe> taxes= new HashSet<>();

    public void setIdCommune(Integer idCommune) {
        this.idCommune=idCommune;
    }
}
