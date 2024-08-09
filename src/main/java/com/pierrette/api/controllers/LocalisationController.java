package com.pierrette.api.controllers;

import com.pierrette.api.entities.Localisation;
import com.pierrette.api.services.LocalisationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/localisation")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58349"})
public class LocalisationController {

    private final LocalisationService localisationService;

    public LocalisationController(LocalisationService localisationService) {
        this.localisationService = localisationService;
    }

    @GetMapping
    public List<Localisation> getAlllocalisations() {
        return localisationService.getAllLocalisations();
    }

    @GetMapping("/{id}")
    public Localisation localisationById(@PathVariable Integer id) {
        return localisationService.getLocalisation(id);
    }

    @PostMapping("/create")
    public Localisation createLocalisation(@RequestBody Localisation localisation) {
        return localisationService.createLocalisation(localisation);
    }

    @PutMapping("/{id}")
    public Localisation updateLocalisation(@PathVariable Integer id, @RequestBody Localisation localisation) {
        return localisationService.updateLocalisation(id, localisation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocalisation(@PathVariable Integer id) {
        localisationService.deleteLocalisation(id);
        return ResponseEntity.ok("Localisation avec l'ID " + id + " a été supprimé avec succès");
    }
}
