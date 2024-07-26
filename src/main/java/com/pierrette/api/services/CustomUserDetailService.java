package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.repositories.OperateurRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {


    //private final DbUserRepo dbUserRepo;
    private final OperateurRepo operateurRepo;

    public CustomUserDetailService(OperateurRepo operateurRepo) {
        //this.dbUserRepo = dbUserRepo;
        this.operateurRepo = operateurRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         //DBUser dbUser = dbUserRepo.findByUsername(username);
        Operateur operateur = operateurRepo.findByUsername(username);
       return new User(operateur.getNom(), operateur.getPassword(), getAuthorities(operateur.getRole().name()));
        //return new User(dbUser.getUsername(), dbUser.getPassword(), getAuthorities(dbUser.getRole()));
    }

    public List<GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
        return authorities;
    }
}
