package com.pierrette.api.services;

import com.pierrette.api.entities.Periodicite;
import com.pierrette.api.repositories.PeriodiciteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodiciteService {

    private final PeriodiciteRepo periodiciteRepository;

    public PeriodiciteService(PeriodiciteRepo periodiciteRepository) {
        this.periodiciteRepository = periodiciteRepository;
    }

    public List<Periodicite> getAllPeriodicites() {
        return periodiciteRepository.findAll();
    }

    public Periodicite createPeriodicite(Periodicite periodicite) {
        return periodiciteRepository.save(periodicite);
    }

    public Periodicite updatePeriodicite(Integer id, Periodicite periodiciteUpdate) {
        Periodicite periodiciteExiste = periodiciteRepository.findById(id).orElse(null);
        assert periodiciteExiste != null;
        periodiciteExiste.setLibelleValidite(periodiciteUpdate.getLibelleValidite());

        return periodiciteRepository.save(periodiciteExiste);

    }

    public Optional<Periodicite> getPeriodicite(Integer idPeriodicite) {
        return periodiciteRepository.findById(idPeriodicite);
    }

    public void deletePeriodicite(Integer id) {
        periodiciteRepository.deleteById(id);
    }
}
