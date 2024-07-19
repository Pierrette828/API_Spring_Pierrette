package com.pierrette.api.services;

import com.pierrette.api.entities.Commune;
import com.pierrette.api.repositories.CommuneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommuneService {

    @Autowired
    private CommuneRepo communeRepository;

    public List<Commune> findAll() {
        return communeRepository.findAll();
    }

    public Optional<Commune> findById(Integer id) {
        return communeRepository.findById(id);
    }

    public Commune save(Commune commune) {
        return communeRepository.save(commune);
    }

    public void deleteById(Integer id) {
        communeRepository.deleteById(id);
    }
}

