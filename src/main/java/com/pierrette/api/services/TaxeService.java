package com.pierrette.api.services;

import com.pierrette.api.entities.Taxe;
import com.pierrette.api.repositories.TaxeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaxeService {

    @Autowired
    private TaxeRepo taxeRepository;

    public List<Taxe> findAll() {
        return taxeRepository.findAll();
    }

    public Optional<Taxe> findById(Integer id) {
        return taxeRepository.findById(id);
    }

    public Taxe save(Taxe taxe) {
        return taxeRepository.save(taxe);
    }

    public void deleteById(Integer id) {
        taxeRepository.deleteById(id);
    }
}
