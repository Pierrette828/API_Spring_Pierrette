package com.pierrette.api.controllers;

import com.pierrette.api.entities.Commune;
import com.pierrette.api.services.CommuneService;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/auth/communes")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58349"})
public class CommuneController {

    private final CommuneService communeService;

    public CommuneController(CommuneService communeService) {
        this.communeService = communeService;
    }

    @GetMapping("/list")
    public List<Commune> getAllCommunes() {
        return communeService.getAllCommunes();
    }

    @GetMapping("/{id}")
    public Commune getCommuneById(@PathVariable Integer id) {
        return communeService.getCommune(id);
    }

    @PostMapping("/add")
    public Commune createCommune(@RequestBody Commune commune) {
        return communeService.createCommune(commune);
    }

    @PutMapping("/{id}")
    public Commune updateCommune(@PathVariable Integer id, @RequestBody Commune commune) {
        return communeService.updateCommune(id, commune);
    }

    @GetMapping("/count")
    public int countCommune() {
        List<Commune> communes = communeService.getAllCommunes(); // Récupère toutes les communes
        Set<String> uniqueCommunes = new HashSet<>();

        for (Commune commune : communes) {
            uniqueCommunes.add(commune.getLibelleCommune()); // Suppose que la méthode getNom() retourne le nom de la commune
        }

        return uniqueCommunes.size();
    }



    @DeleteMapping("/{id}")
    public void deleteCommune(@PathVariable Integer id) {
        communeService.deleteCommune(id);
    }
}

