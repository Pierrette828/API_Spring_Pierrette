package com.pierrette.api.entities;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prefecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrefecture;
    private String libellePrefecture;
    private String libelleVille;

    @OneToMany(mappedBy = "prefecture" )
    private List<Commune> communes;

    @ManyToOne
    @JoinColumn(name = "idVille")
    private Ville ville;

    public void setIdPrefecture(Integer idPrefecture) {
        this.idPrefecture=idPrefecture;
    }
}
