package com.pierrette.api.controllers;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.entities.Paiement;
import com.pierrette.api.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paiement")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    /*@GetMapping("/{id}")
    public Optional<Paiement> getPaiementById(@PathVariable Integer id) {
        return paiementService.findById(id);
    }*/

    @PostMapping("/create")
    public Paiement createPaiement(@RequestBody Paiement paiement) {
        return paiementService.createPaiement(paiement);
    }

    @PutMapping("/{id}")
    public Paiement updatePaiement(@PathVariable Integer id, @RequestBody Paiement paiement) {
        // paiement.setIdPaiement(id);
        return paiementService.updatePaiement(id,paiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaiement(@PathVariable Integer id) {
        paiementService.deletePaiement(id);
        return ResponseEntity.ok("Paiement avec l'ID " + id + " a été supprimé avec succès");
    }
}
