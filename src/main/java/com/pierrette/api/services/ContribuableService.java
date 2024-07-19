package com.pierrette.api.services;

import com.pierrette.api.entities.Contribuable;
import com.pierrette.api.repositories.ContribuableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContribuableService {

    @Autowired
    private ContribuableRepo contribuableRepository;

    public List<Contribuable> findAll() {
        return contribuableRepository.findAll();
    }

    public Optional<Contribuable> findById(Integer id) {
        return contribuableRepository.findById(id);
    }

    public Contribuable save(Contribuable contribuable) {
        return contribuableRepository.save(contribuable);
    }

    public void deleteById(Integer id) {
        contribuableRepository.deleteById(id);
    }
}

