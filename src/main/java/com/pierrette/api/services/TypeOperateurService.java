package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.entities.Type_operateur;
import com.pierrette.api.repositories.OperateurRepo;
import com.pierrette.api.repositories.TypeOperateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeOperateurService {

    @Autowired
    private TypeOperateurRepo typeOperateurRepository;


    public List<Type_operateur> getAllTypeOperateurs(){
        return typeOperateurRepository.findAll();
    }

    public Type_operateur createTypeOperateur(Type_operateur typeOperateur){
        return typeOperateurRepository.save(typeOperateur);
    }

    public Type_operateur updateTypeOperateur(Integer id, Type_operateur typeOperateurUpdate){
        Type_operateur typeOperateurExiste = typeOperateurRepository.findById(id).orElse(null);
        if (typeOperateurExiste!=null){
            typeOperateurExiste.setOperateur_formel(typeOperateurUpdate.getOperateur_formel());
            typeOperateurExiste.setOperateur_informel(typeOperateurUpdate.getOperateur_informel());

            Type_operateur typeOperateurAjour = typeOperateurRepository.save(typeOperateurExiste);

        } return typeOperateurExiste;
    }

    public String deleteTypeOperateur(Integer id) {
        if(id!=0){
            typeOperateurRepository.deleteById(id);
            return "Suppression";
        }
        return null;
    }

    public Type_operateur getTypeOperateur(Integer idOperateur){
        return typeOperateurRepository.findById(idOperateur).get();
    }

}
