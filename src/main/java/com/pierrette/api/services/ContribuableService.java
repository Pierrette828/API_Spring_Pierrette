package com.pierrette.api.services;

import com.pierrette.api.entities.Contribuable;
import com.pierrette.api.repositories.ContribuableRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContribuableService {

    private final ContribuableRepo contribuableRepository;

    public ContribuableService(ContribuableRepo contribuableRepository) {
        this.contribuableRepository = contribuableRepository;
    }


    public List<Contribuable> getAllContribuable() {
        return contribuableRepository.findAll();
    }

    public Contribuable createContribuable(Contribuable contribuable) {
        return contribuableRepository.save(contribuable);
    }

    public Contribuable updateContribuable(Integer id, Contribuable contribuableUpdate) {
        Contribuable contribuableExiste = contribuableRepository.findById(id).orElse(null);
        assert contribuableExiste != null;
        contribuableExiste.setNom(contribuableUpdate.getNom());
        contribuableExiste.setPrenom(contribuableUpdate.getPrenom());
        contribuableExiste.setAdresse(contribuableUpdate.getAdresse());
        contribuableExiste.setTypeActivite(contribuableUpdate.getTypeActivite());

        return contribuableRepository.save(contribuableExiste);

    }

    public void deleteContribuable(Integer id) {
        if (id != 0) {
            contribuableRepository.deleteById(id);
        }
    }

    public Contribuable getContribuable(Integer idContribuable) {
        return contribuableRepository.findById(idContribuable).orElse(null);
    }
}