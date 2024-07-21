package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.repositories.OperateurRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperateurService {

    private final OperateurRepo operateurRepository;

    public OperateurService(OperateurRepo operateurRepository) {
        this.operateurRepository = operateurRepository;
    }


    public List<Operateur> getAllOperateurs() {
        return operateurRepository.findAll();
    }

    public Operateur createOperateur(Operateur operateur) {
        return operateurRepository.save(operateur);
    }

    public Operateur updateOperateur(Integer id, Operateur operateurUpdate) {
        Operateur operateurExiste = operateurRepository.findById(id).orElse(null);
        assert operateurExiste != null;
        operateurExiste.setNom(operateurUpdate.getNom());
        operateurExiste.setPrenom(operateurUpdate.getPrenom());
        operateurExiste.setTelephone(operateurUpdate.getTelephone());
        operateurExiste.setSexe(operateurUpdate.getSexe());

        return operateurRepository.save(operateurExiste);

    }

    public void deleteOperateur(Integer id) {
        if (id != 0) {
            operateurRepository.deleteById(id);
        }
    }

    public Optional<Operateur> getOperateur(Integer id) {
        return operateurRepository.findById(id);
    }

}
