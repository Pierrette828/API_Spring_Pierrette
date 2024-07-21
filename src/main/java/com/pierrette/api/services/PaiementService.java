package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.entities.Paiement;
import com.pierrette.api.repositories.OperateurRepo;
import com.pierrette.api.repositories.PaiementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepo paiementRepository;


    public List<Paiement> getAllPaiements(){
        return paiementRepository.findAll();
    }

    public Paiement createPaiement(Paiement paiement){
        return paiementRepository.save(paiement);
    }

    public Paiement updatePaiement(Integer id, Paiement paiementUpdate){
       Paiement paiementExiste = paiementRepository.findById(id).orElse(null);
        if (paiementExiste!=null){
            paiementExiste.setDatePaiement(paiementUpdate.getDatePaiement());
            paiementExiste.setMontant(paiementUpdate.getMontant());

           Paiement paiementAjour = paiementRepository.save(paiementExiste);

        } return paiementExiste;
    }

    public String deletePaiement(Integer id) {
        if(id!=0){
            paiementRepository.deleteById(id);
            return "Suppression";
        }
        return null;
    }

    public Paiement getPaiement(Integer idPaiement){
        return paiementRepository.findById(idPaiement).get();
    }

}
