package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.entities.Periodicite;
import com.pierrette.api.repositories.OperateurRepo;
import com.pierrette.api.repositories.PeriodiciteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PeriodiciteService {

    @Autowired
    private PeriodiciteRepo periodiciteRepository;


    public List<Periodicite> getAllPeriodicites(){
        return periodiciteRepository.findAll();
    }

    public Periodicite createPeriodicite(Periodicite periodicite){
        return periodiciteRepository.save(periodicite);
    }

    public Periodicite updatePeriodicite(Integer id, Periodicite periodiciteUpdate){
        Periodicite periodiciteExiste = periodiciteRepository.findById(id).orElse(null);
        if (periodiciteExiste!=null){
            periodiciteExiste.setLibelleValidite(periodiciteUpdate.getLibelleValidite());

          Periodicite periodiciteAjour = periodiciteRepository.save(periodiciteExiste);

        } return periodiciteExiste;
    }

    public String deletePeriodicite(Integer id) {
        if(id!=0){
            periodiciteRepository.deleteById(id);
            return "Suppression";
        }
        return null;
    }

    public Periodicite getPeriodicite(Integer idPeriodicite){
        return periodiciteRepository.findById(idPeriodicite).get();
    }
}
