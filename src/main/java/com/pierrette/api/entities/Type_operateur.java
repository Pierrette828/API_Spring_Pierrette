package com.pierrette.api.entities;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Type_operateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idType_operateur;
    private String operateur_formel;
    private String operateur_informel;

//    @OneToMany(mappedBy ="typeOperateur")
//    private List<Operateur> operateurs;


}
