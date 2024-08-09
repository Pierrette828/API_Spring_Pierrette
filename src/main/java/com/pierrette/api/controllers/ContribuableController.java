package com.pierrette.api.controllers;

import com.pierrette.api.entities.Contribuable;
import com.pierrette.api.services.ContribuableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/contribuable")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:50085/"})
public class ContribuableController {

    private final ContribuableService contribuableService;

    public ContribuableController(ContribuableService contribuableService) {
        this.contribuableService = contribuableService;
    }

    @GetMapping("/list")
    public List<Contribuable> getAllOContribuables() {
        return contribuableService.getAllContribuable();
    }

    @GetMapping("/{id}")
    public Contribuable getContribuableById(@PathVariable Integer id) {
        return contribuableService.getContribuable(id);
    }

    @PostMapping("/save")
    public Contribuable createContribuable(@RequestBody Contribuable contribuable) {
        return contribuableService.createContribuable(contribuable);
    }

    @PutMapping("/update/{id}")
    public Contribuable updateContribuable(@PathVariable Integer id, @RequestBody Contribuable contribuable) {

        return contribuableService.updateContribuable(id, contribuable);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContribuable(@PathVariable Integer id) {
        contribuableService.deleteContribuable(id);
        return ResponseEntity.ok("Contribuable avec l'ID " + id + " a été supprimé avec succès");
    }
}
