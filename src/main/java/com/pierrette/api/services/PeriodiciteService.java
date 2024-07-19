package com.pierrette.api.services;

import com.pierrette.api.entities.Periodicite;
import com.pierrette.api.repositories.PeriodiciteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PeriodiciteService {

    @Autowired
    private PeriodiciteRepo periodiciteRepository;

    public List<Periodicite> findAll() {
        return periodiciteRepository.findAll();
    }

    public Optional<Periodicite> findById(Integer id) {
        return periodiciteRepository.findById(id);
    }

    public Periodicite save(Periodicite periodicite) {
        return periodiciteRepository.save(periodicite);
    }

    public void deleteById(Integer id) {
        periodiciteRepository.deleteById(id);
    }
}
