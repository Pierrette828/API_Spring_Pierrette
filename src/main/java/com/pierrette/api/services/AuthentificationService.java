package com.pierrette.api.services;

import com.pierrette.api.configuration.JwtService;
import com.pierrette.api.entities.Operateur;
import com.pierrette.api.enumeration.Role;
import com.pierrette.api.repositories.OperateurRepo;
import com.pierrette.api.requests.LoginRequest;
import com.pierrette.api.requests.SignUp;
import com.pierrette.api.response.AuthenficationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthentificationService {
    private final OperateurRepo operateurRepo;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService  jwtService;


    public  AuthenficationResponse signIn (LoginRequest dto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dto.getUsername(),dto.getPasssword()
        ));
        Operateur operateur= operateurRepo.findByUsername(dto.getUsername());
        String token = jwtService.generateToken(operateur );

        return new AuthenficationResponse(token,operateur);
    }


    public String signUp (SignUp dto){
        Operateur operateur= operateurRepo.findByUsername(dto.getUsername());
        if(operateur!=null){
            throw new IllegalArgumentException("Choisissez un autre username");
        } else{
            Operateur operator = new Operateur();
            operator.setUsername(dto.getUsername());
            operator.setNom(dto.getNom());
            operator.setPrenom(dto.getPrenom());
            operator.setSexe(dto.getSexe());
            operator.setPiece_identite(dto.getPiece_identite());
            operator.setRole(Role.valueOf(dto.getRole()));
            operator.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
            operateurRepo.save(operator);
            return "Compte crer avec succès";
        }
    }
}
