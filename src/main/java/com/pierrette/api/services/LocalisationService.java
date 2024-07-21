package com.pierrette.api.services;

import com.pierrette.api.entities.Localisation;
import com.pierrette.api.repositories.LocalisationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalisationService {
    private final LocalisationRepo localisationRepository;

    public LocalisationService(LocalisationRepo localisationRepository) {
        this.localisationRepository = localisationRepository;
    }


    public List<Localisation> getAllLocalisations() {
        return localisationRepository.findAll();
    }

    public Localisation createLocalisation(Localisation localisation) {
        return localisationRepository.save(localisation);
    }

    public Localisation updateLocalisation(Integer id, Localisation localisationUpdate) {
        Localisation localisationExiste = localisationRepository.findById(id).orElse(null);
        assert localisationExiste != null;
        localisationExiste.setLatitude(localisationUpdate.getLatitude());
        localisationExiste.setLongitude(localisationUpdate.getLongitude());

        return localisationRepository.save(localisationExiste);

    }

    public void deleteLocalisation(Integer id) {
        if (id != 0) {
            localisationRepository.deleteById(id);
        }
    }

    public Localisation getLocalisation(Integer idLocalisation) {
        return localisationRepository.findById(idLocalisation).orElse(null);
    }

}

