package com.pierrette.api.controllers;

import com.pierrette.api.entities.Paiement;
import com.pierrette.api.services.PaiementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/paiement")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58349"})
public class PaiementController {


    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/{id}")
    public Optional<Paiement> getPaiementById(@PathVariable Integer id) {
        return paiementService.getPaiement(id);
    }

    @PostMapping("/create")
    public Paiement createPaiement(@RequestBody Paiement paiement) {
        return paiementService.createPaiement(paiement);
    }

    @PutMapping("/{id}")
    public Paiement updatePaiement(@PathVariable Integer id, @RequestBody Paiement paiement) {

        return paiementService.updatePaiement(id, paiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaiement(@PathVariable Integer id) {
        paiementService.deletePaiement(id);
        return ResponseEntity.ok("Paiement avec l'ID " + id + " a été supprimé avec succès");
    }
}
