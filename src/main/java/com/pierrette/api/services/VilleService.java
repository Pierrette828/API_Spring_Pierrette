package com.pierrette.api.services;

import com.pierrette.api.entities.Contribuable;
import com.pierrette.api.entities.Ville;
import com.pierrette.api.repositories.VilleRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VilleService {

    private final VilleRepo villeRepository;

    public VilleService(VilleRepo villeRepository) {
        this.villeRepository = villeRepository;
    }

    public List<Ville> getAll() {
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

    @PostConstruct
    public void init() {
        if (villeRepository.count() != 0) {
//            Ville ville = new Ville();
//            ville.setLibelleVille("Paris");
//            villeRepository.save(ville);
            System.out.println("Ville exist");
        }
    }

    public Integer countVille(){

        List<Ville> villeList=  getAll();
        return villeList.size();
    }

    public void deleteById(Integer id) {
        villeRepository.deleteById(id);
    }
}

