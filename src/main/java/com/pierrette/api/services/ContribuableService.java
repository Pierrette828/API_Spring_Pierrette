package com.pierrette.api.services;

import com.pierrette.api.entities.Contribuable;
import com.pierrette.api.entities.Operateur;
import com.pierrette.api.repositories.ContribuableRepo;
import com.pierrette.api.repositories.OperateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContribuableService {

    @Autowired
    private ContribuableRepo contribuableRepository;


    public List<Contribuable> getAllContribuable(){
        return contribuableRepository.findAll();
    }

    public Contribuable createContribuable(Contribuable contribuable){
        return contribuableRepository.save(contribuable);
    }

    public Contribuable updateContribuable(Integer id, Contribuable contribuableUpdate){
        Contribuable contribuableExiste = contribuableRepository.findById(id).orElse(null);
        if (contribuableExiste!=null){
            contribuableExiste.setNom(contribuableUpdate.getNom());
            contribuableExiste.setPrenom(contribuableUpdate.getPrenom());
            contribuableExiste.setAdresse(contribuableUpdate.getAdresse());
            contribuableExiste.setTypeActivite(contribuableUpdate.getTypeActivite());

            Contribuable contribuableAjour = contribuableRepository.save(contribuableExiste);

        } return contribuableExiste;
    }

    public String deleteContribuable(Integer id) {
        if(id!=0){
            contribuableRepository.deleteById(id);
            return "Suppression";
        }
        return null;
    }

    public Contribuable getContribuable(Integer idContribuable){
        return contribuableRepository.findById(idContribuable).get();
    }
}