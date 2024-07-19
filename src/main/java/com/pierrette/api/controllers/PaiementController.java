package com.pierrette.api.controllers;

import com.pierrette.api.entities.Paiement;
import com.pierrette.api.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Paiement> getPaiementById(@PathVariable Integer id) {
        return paiementService.findById(id);
    }

    @PostMapping
    public Paiement createPaiement(@RequestBody Paiement paiement) {
        return paiementService.save(paiement);
    }

    @PutMapping("/{id}")
    public Paiement updatePaiement(@PathVariable Integer id, @RequestBody Paiement paiement) {
      //  paiement.setIdPaiement(id);
        return paiementService.save(paiement);
    }

    @DeleteMapping("/{id}")
    public void deletePaiement(@PathVariable Integer id) {
        paiementService.deleteById(id);
    }
}
