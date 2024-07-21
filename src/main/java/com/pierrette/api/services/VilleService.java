package com.pierrette.api.services;

import com.pierrette.api.entities.Ville;
import com.pierrette.api.repositories.VilleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VilleService {

    @Autowired
    private VilleRepo villeRepository;

    public List<Ville> findAll() {
        return villeRepository.findAll();
    }

    public Optional<Ville> findById(Integer id) {
        return villeRepository.findById(id);
    }

    public Ville save(Ville ville) {
        return villeRepository.save(ville);
    }

    @Transactional
    public Ville update(Integer id, Ville ville) {
        Ville villeExist = villeRepository.findById(id).orElse(null);

        assert villeExist != null;
        villeExist.setLibelleVille(ville.getLibelleVille());

        return villeRepository.save(villeExist);
    }
    public void deleteById(Integer id) {
        villeRepository.deleteById(id);
    }
}

