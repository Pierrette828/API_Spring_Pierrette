package com.pierrette.api.entities;

import jakarta.persistence.*;
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
public class Operateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOperateur;
    private String nom;
    private String prenom;
    private Integer telephone;
    private String sexe;
    private String password;
    @Column(nullable = true)
    private Byte piece_identite;

    @ManyToOne
    @JoinColumn(name = "idType_operateur")
    private Type_operateur typeOperateur;

    @OneToMany(mappedBy = "operateur")
    private List<Paiement> paiements;

    @OneToOne
    @JoinColumn(name = "idTerminal")
    private Terminal terminal;

    public Integer getIdOperateur() {
        return idOperateur;
    }

    public void setIdOperateur(Integer idOperateur) {
        this.idOperateur = idOperateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getPiece_identite() {
        return piece_identite;
    }

    public void setPiece_identite(Byte piece_identite) {
        this.piece_identite = piece_identite;
    }

    public Type_operateur getTypeOperateur() {
        return typeOperateur;
    }

    public void setTypeOperateur(Type_operateur typeOperateur) {
        this.typeOperateur = typeOperateur;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}
