package com.pierrette.api.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pierrette.api.entities.Commune;
import com.pierrette.api.services.CommuneService;

@RestController
@RequestMapping("/api/v1/auth/communes")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58349"})
public class CommuneController {

    @Autowired
    private CommuneService communeService;

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

    // Forcer l'envoi et le retour en JSON pour une requête POST
    @PostMapping(value = "/add" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Commune> createCommune(@RequestBody Commune commune) {
        return ResponseEntity.status(HttpStatus.OK).body(this.communeService.createCommune(commune));
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

