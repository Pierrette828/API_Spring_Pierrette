package com.pierrette.api.controllers;

import com.pierrette.api.entities.Ville;
import com.pierrette.api.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/villes")
public class VilleController {

    @Autowired
    private VilleService villeService;

    @GetMapping
    public List<Ville> getAllVilles() {
        return villeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ville> getVilleById(@PathVariable Integer id) {
        return villeService.findById(id);
    }

    @PostMapping
    public Ville createVille(@RequestBody Ville ville) {
        return villeService.save(ville);
    }

    @PutMapping("/{id}")
    public Ville updateVille(@PathVariable Integer id, @RequestBody Ville ville) {
       // ville.setIdVille(id);
        return villeService.save(ville);
    }

    @DeleteMapping("/{id}")
    public void deleteVille(@PathVariable Integer id) {
        villeService.deleteById(id);
    }
}

