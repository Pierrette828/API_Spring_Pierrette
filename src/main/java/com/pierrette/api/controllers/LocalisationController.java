package com.pierrette.api.controllers;

import com.pierrette.api.entities.Localisation;
import com.pierrette.api.services.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/localisations")
public class LocalisationController {

    @Autowired
    private LocalisationService localisationService;

    @GetMapping
    public List<Localisation> getAllLocalisations() {
        return localisationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Localisation> getLocalisationById(@PathVariable Integer id) {
        return localisationService.findById(id);
    }

    @PostMapping
    public Localisation createLocalisation(@RequestBody Localisation localisation) {
        return localisationService.save(localisation);
    }

    @PutMapping("/{id}")
    public Localisation updateLocalisation(@PathVariable Integer id, @RequestBody Localisation localisation) {
       // localisation.setIdLocalisation(id);
        return localisationService.save(localisation);
    }

    @DeleteMapping("/{id}")
    public void deleteLocalisation(@PathVariable Integer id) {
        localisationService.deleteById(id);
    }
}

