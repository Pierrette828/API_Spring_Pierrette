package com.pierrette.api.services;

import com.pierrette.api.entities.Localisation;
import com.pierrette.api.repositories.LocalisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocalisationService {

    @Autowired
    private LocalisationRepo localisationRepository;

    public List<Localisation> findAll() {
        return localisationRepository.findAll();
    }

    public Optional<Localisation> findById(Integer id) {
        return localisationRepository.findById(id);
    }

    public Localisation save(Localisation localisation) {
        return localisationRepository.save(localisation);
    }

    public void deleteById(Integer id) {
        localisationRepository.deleteById(id);
    }
}
