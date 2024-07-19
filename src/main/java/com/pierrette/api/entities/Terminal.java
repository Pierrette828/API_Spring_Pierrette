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

    @OneToOne(mappedBy = "terminal")
    private Operateur operateur;

    public void setIdType(Integer idTpe) {
        this.idTpe=idTpe;

    }
}
