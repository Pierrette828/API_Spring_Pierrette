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
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocalisation;
    private double longitude;
    private double latitude;

    @ManyToMany(mappedBy = "localisations")
    private Set<Terminal> terminals = new HashSet<>();

    public void setIdLocalisation(Integer idLocalisation) {
        this.idLocalisation=idLocalisation;
    }
}
