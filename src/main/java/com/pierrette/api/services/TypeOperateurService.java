package com.pierrette.api.services;

import com.pierrette.api.entities.Type_operateur;
import com.pierrette.api.repositories.TypeOperateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeOperateurService {

    @Autowired
    private TypeOperateurRepo typeOperateurRepository;

    public List<Type_operateur> findAll() {
        return typeOperateurRepository.findAll();
    }

    public Optional<Type_operateur> findById(Integer id) {
        return typeOperateurRepository.findById(id);
    }

    public Type_operateur save(Type_operateur typeOperateur) {
        return typeOperateurRepository.save(typeOperateur);
    }

    public void deleteById(Integer id) {
        typeOperateurRepository.deleteById(id);
    }
}
