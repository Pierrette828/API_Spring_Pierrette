package com.pierrette.api.services;

import com.pierrette.api.entities.Localisation;
import com.pierrette.api.entities.Operateur;
import com.pierrette.api.repositories.LocalisationRepo;
import com.pierrette.api.repositories.OperateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocalisationService {

    @Autowired
    private LocalisationRepo localisationRepository;


    public List<Localisation> getAllLocalisations(){
        return localisationRepository.findAll();
    }

    public Localisation createLocalisation(Localisation localisation){
        return localisationRepository.save(localisation);
    }

    public Localisation updateLocalisation(Integer id,Localisation localisationUpdate){
        Localisation localisationExiste = localisationRepository.findById(id).orElse(null);
        if (localisationExiste!=null){
            localisationExiste.setLatitude(localisationUpdate.getLatitude());
            localisationExiste.setLongitude(localisationUpdate.getLongitude());

            Localisation localisationAjour = localisationRepository.save(localisationExiste);

        } return localisationExiste;
    }

    public String deleteLocalisation(Integer id) {
        if(id!=0){
            localisationRepository.deleteById(id);
            return "Suppression";
        }
        return null;
    }

    public Localisation getLocalisation(Integer idLocalisation){
        return localisationRepository.findById(idLocalisation).get();
    }

}

