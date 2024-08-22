package com.pierrette.api.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUp {
    private String username;
    private String nom;
    private String prenom;
    private String telephone;
    private String sexe;
    private String password;
    private int piece_identite;
    private String role;
}
