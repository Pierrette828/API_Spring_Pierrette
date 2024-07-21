package com.pierrette.api.services;

import com.pierrette.api.entities.Paiement;
import com.pierrette.api.repositories.PaiementRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    private final PaiementRepo paiementRepository;

    public PaiementService(PaiementRepo paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Paiement createPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public Paiement updatePaiement(Integer id, Paiement paiementUpdate) {
        Paiement paiementExiste = paiementRepository.findById(id).orElse(null);
        assert paiementExiste != null;
        paiementExiste.setDatePaiement(paiementUpdate.getDatePaiement());
        paiementExiste.setMontant(paiementUpdate.getMontant());

        return paiementRepository.save(paiementExiste);
    }

    public void deletePaiement(Integer id) {
        if (id != 0) {
            paiementRepository.deleteById(id);
        }
    }

    public Optional<Paiement> getPaiement(Integer idPaiement) {
        return paiementRepository.findById(idPaiement);
    }

}
