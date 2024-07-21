package com.pierrette.api.controllers;

import com.pierrette.api.entities.Periodicite;
import com.pierrette.api.services.PeriodiciteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/periodicite")
public class PeriodiciteController {

    private final PeriodiciteService periodiciteService;

    public PeriodiciteController(PeriodiciteService periodiciteService) {
        this.periodiciteService = periodiciteService;
    }

    @GetMapping
    public List<Periodicite> getAllPeriodicites() {
        return periodiciteService.getAllPeriodicites();
    }

    @GetMapping("/{id}")
    public Optional<Periodicite> getPeriodiciteById(@PathVariable Integer id) {
        return periodiciteService.getPeriodicite(id);
    } 

    @PostMapping("/create")
    public Periodicite createPeriodicite(@RequestBody Periodicite periodicite) {
        return periodiciteService.createPeriodicite(periodicite);
    }

    @PutMapping("/{id}")
    public Periodicite updatePeriodicite(@PathVariable Integer id, @RequestBody Periodicite periodicite) {
        return periodiciteService.updatePeriodicite(id, periodicite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePeriodicite(@PathVariable Integer id) {
        periodiciteService.deletePeriodicite(id);
        return ResponseEntity.ok("Periodicite avec l'ID " + id + " a été supprimée avec succès");
    }
}
