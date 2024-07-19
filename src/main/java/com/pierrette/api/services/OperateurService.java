package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.repositories.OperateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OperateurService implements IOperateurService {

    @Autowired
    private OperateurRepo operateurRepository;

    @Override
    public List<Operateur> getAllOperateurs(){
       return operateurRepository.findAll();
   }
   @Override
    public Operateur createOperateur(Operateur operateur){
        return operateurRepository.save(operateur);
   }

    @Override
    public Operateur updateOperateur(Integer id) {
        return null;
    }

    @Override
    public void deleteOperateur(Integer id) {

    }

    @Override
    public Operateur getOperateur(Integer idOperateur){
        return operateurRepository.findById(idOperateur).get();
   }

}
