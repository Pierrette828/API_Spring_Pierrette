package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.repositories.OperateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OperateurService {

    @Autowired
    private OperateurRepo operateurRepository;


    public List<Operateur> getAllOperateurs(){
       return operateurRepository.findAll();
   }

    public Operateur createOperateur(Operateur operateur){
        return operateurRepository.save(operateur);
   }

    public Operateur updateOperateur(Integer id, Operateur operateurUpdate){
        Operateur operateurExiste = operateurRepository.findById(id).orElse(null);
        if (operateurExiste!=null){
            operateurExiste.setNom(operateurUpdate.getNom());
            operateurExiste.setPrenom(operateurUpdate.getPrenom());
            operateurExiste.setTelephone(operateurUpdate.getTelephone());
            operateurExiste.setSexe(operateurUpdate.getSexe());

            Operateur operateurAjour = operateurRepository.save(operateurExiste);

        } return operateurExiste;
    }

    public String deleteOperateur(Integer id) {
        if(id!=0){
            operateurRepository.deleteById(id);
            return "Suppression";
        }
        return null;
    }

    public Operateur getOperateur(Integer idOperateur){
        return operateurRepository.findById(idOperateur).get();
   }

}
