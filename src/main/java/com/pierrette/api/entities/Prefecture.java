package com.pierrette.api.entities;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
