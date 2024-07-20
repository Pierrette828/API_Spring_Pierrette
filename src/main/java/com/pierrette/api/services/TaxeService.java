package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.entities.Taxe;
import com.pierrette.api.repositories.OperateurRepo;
import com.pierrette.api.repositories.TaxeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaxeService {

    @Autowired
    private TaxeRepo taxeRepository;


    public List<Taxe> getAllTaxes(){
        return taxeRepository.findAll();
    }

    public Taxe createTaxe(Taxe taxe){
        return taxeRepository.save(taxe);
    }

    public Taxe updateTaxe(Integer id, Taxe taxeUpdate){
        Taxe taxeExiste = taxeRepository.findById(id).orElse(null);
        if (taxeExiste!=null){
            taxeExiste.setLibelleTaxe(taxeUpdate.getLibelleTaxe());
            Taxe taxeAjour = taxeRepository.save(taxeExiste);

        } return taxeExiste;
    }

    public String deleteTaxe(Integer id) {
        if(id!=0){
            taxeRepository.deleteById(id);
            return "Suppression";
        }
        return null;
    }

    public Taxe getTaxe(Integer idTaxe){
        return taxeRepository.findById(idTaxe).get();
    }

}