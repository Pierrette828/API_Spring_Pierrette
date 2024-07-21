package com.pierrette.api.services;

import com.pierrette.api.entities.Type_operateur;
import com.pierrette.api.repositories.TypeOperateurRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TypeOperateurService {


    private final TypeOperateurRepo typeOperateurRepository;

    public TypeOperateurService(TypeOperateurRepo typeOperateurRepository) {
        this.typeOperateurRepository = typeOperateurRepository;
    }


    public List<Type_operateur> getAllTypeOperateurs() {
        return typeOperateurRepository.findAll();
    }

    public Type_operateur createTypeOperateur(Type_operateur typeOperateur) {
        return typeOperateurRepository.save(typeOperateur);
    }

    public Type_operateur updateTypeOperateur(Integer id, Type_operateur typeOperateurUpdate) {
        Type_operateur typeOperateurExiste = typeOperateurRepository.findById(id).orElse(null);
        assert typeOperateurExiste != null;
        typeOperateurExiste.setOperateur_formel(typeOperateurUpdate.getOperateur_formel());
        typeOperateurExiste.setOperateur_informel(typeOperateurUpdate.getOperateur_informel());
        return typeOperateurRepository.save(typeOperateurExiste);
    }

    public void deleteTypeOperateur(Integer id) {
        if (id != 0) {
            typeOperateurRepository.deleteById(id);
        }
    }

    public Optional<Type_operateur> getTypeOperateur(Integer idOperateur) {
        return typeOperateurRepository.findById(idOperateur);
    }

}


