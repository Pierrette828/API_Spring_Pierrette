package com.pierrette.api.controllers;

import com.pierrette.api.entities.Commune;
import com.pierrette.api.services.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/communes")
public class CommuneController {

    @Autowired
    private CommuneService communeService;

    @GetMapping
    public List<Commune> getAllCommunes() {
        return communeService.findAll();
    }

    @GetMapping("/{idOperateur}")
    public Optional<Commune> getCommuneById(@PathVariable Integer id) {
        return communeService.findById(id);
    }

    @PostMapping
    public Commune createCommune(@RequestBody Commune commune) {
        return communeService.save(commune);
    }

    @PutMapping("/{id}")
    public Commune updateCommune(@PathVariable Integer id, @RequestBody Commune commune) {
        //commune.setIdCommune(id);
        return communeService.save(commune);
    }

    @DeleteMapping("/{id}")
    public void deleteCommune(@PathVariable Integer id) {
        communeService.deleteById(id);
    }
}

