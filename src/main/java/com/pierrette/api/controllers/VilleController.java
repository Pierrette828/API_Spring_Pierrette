package com.pierrette.api.controllers;

import com.pierrette.api.entities.Ville;
import com.pierrette.api.services.VilleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/villes")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58349"})
public class VilleController {

    private final VilleService villeService;

    @GetMapping
    public List<Ville> getAllVilles() {
        return villeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Ville> getVilleById(@PathVariable Integer id) {
        return villeService.findById(id);
    }

    @PostMapping("/add")
    public Ville createVille(@RequestBody Ville ville) {
        return villeService.save(ville);
    }

    @PutMapping("/{id}")
    public Ville updateVille(@PathVariable Integer id, @RequestBody Ville ville) {

        return villeService.update(id,ville);
    }

    @GetMapping("/count")
    public int countVille() {
        return villeService.countVille();
    }

    @DeleteMapping("/{id}")
    public void deleteVille(@PathVariable Integer id) {
        villeService.deleteById(id);
    }
}

