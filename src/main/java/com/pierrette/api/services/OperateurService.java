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

    public List<Operateur> findAll() {
        return operateurRepository.findAll();
    }

    public Optional<Operateur> findById(Integer id) {
        return operateurRepository.findById(id);
    }

    public Operateur save(Operateur operateur) {
        return operateurRepository.save(operateur);
    }

    public void deleteById(Integer id) {
        operateurRepository.deleteById(id);
    }
}
