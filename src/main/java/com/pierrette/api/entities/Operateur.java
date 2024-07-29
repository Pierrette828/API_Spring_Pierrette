package com.pierrette.api.entities;

import com.pierrette.api.enumeration.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Operateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOperateur;
    @Column (unique = true)
    private String username;
    private String nom;
    private String prenom;
    private Integer telephone;
    private String sexe;
    private String password;
    @Column(nullable = true)
    private String piece_identite;
    @Enumerated(EnumType.STRING)
    private Role role;



    @OneToMany(mappedBy = "operateur")
    private List<Paiement> paiements;

    @OneToOne
    @JoinColumn(name = "idTerminal")
    private Terminal terminal;

    public Operateur(String nom, String password, Type_operateur typeOperateur) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
