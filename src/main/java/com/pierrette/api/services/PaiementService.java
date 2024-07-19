package com.pierrette.api.services;

import com.pierrette.api.entities.Paiement;
import com.pierrette.api.repositories.PaiementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepo paiementRepository;

    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    public Optional<Paiement> findById(Integer id) {
        return paiementRepository.findById(id);
    }

    public Paiement save(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public void deleteById(Integer id) {
        paiementRepository.deleteById(id);
    }
}
