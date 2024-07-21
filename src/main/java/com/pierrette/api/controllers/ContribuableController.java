package com.pierrette.api.controllers;

import com.pierrette.api.entities.Contribuable;
import com.pierrette.api.services.ContribuableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contribuable")
public class ContribuableController {

    private final ContribuableService contribuableService;

    public ContribuableController(ContribuableService contribuableService) {
        this.contribuableService = contribuableService;
    }

    @GetMapping
    public List<Contribuable> getAllOContribuables() {
        return contribuableService.getAllContribuable();
    }

    @GetMapping("/{id}")
    public Contribuable getContribuableById(@PathVariable Integer id) {
        return contribuableService.getContribuable(id);
    }

    @PostMapping("/create")
    public Contribuable createContribuable(@RequestBody Contribuable contribuable) {
        return contribuableService.createContribuable(contribuable);
    }

    @PutMapping("/{id}")
    public Contribuable updateContribuable(@PathVariable Integer id, @RequestBody Contribuable contribuable) {

        return contribuableService.updateContribuable(id, contribuable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContribuable(@PathVariable Integer id) {
        contribuableService.deleteContribuable(id);
        return ResponseEntity.ok("Contribuable avec l'ID " + id + " a été supprimé avec succès");
    }
}
