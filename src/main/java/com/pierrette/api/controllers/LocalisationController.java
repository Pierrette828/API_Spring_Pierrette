package com.pierrette.api.controllers;

import com.pierrette.api.entities.Localisation;
import com.pierrette.api.services.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/localisation")
public class LocalisationController {

    @Autowired
    private LocalisationService localisationService;

    @GetMapping
    public List<Localisation> getAlllocalisations() {
        return localisationService.getAllLocalisations();
    }

    /*@GetMapping("/{id}")
    public Optional<Localisation> localisationById(@PathVariable Integer id) {
        return localisationService.getAllLocalisations();
    }*/

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
