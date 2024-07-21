package com.pierrette.api.services;

import com.pierrette.api.entities.Taxe;
import com.pierrette.api.repositories.TaxeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxeService {

    private final TaxeRepo taxeRepository;

    public TaxeService(TaxeRepo taxeRepository) {
        this.taxeRepository = taxeRepository;
    }


    public List<Taxe> getAllTaxes() {
        return taxeRepository.findAll();
    }

    public Taxe createTaxe(Taxe taxe) {
        return taxeRepository.save(taxe);
    }

    public Taxe updateTaxe(Integer id, Taxe taxeUpdate) {
        Taxe taxeExiste = taxeRepository.findById(id).orElse(null);
        assert taxeExiste != null;
        taxeExiste.setLibelleTaxe(taxeUpdate.getLibelleTaxe());
        return taxeRepository.save(taxeExiste);

    }

    public void deleteTaxe(Integer id) {
        if (id != 0) {
            taxeRepository.deleteById(id);
        }
    }

    public Optional<Taxe> getTaxe(Integer idTaxe) {
        return taxeRepository.findById(idTaxe);
    }

}