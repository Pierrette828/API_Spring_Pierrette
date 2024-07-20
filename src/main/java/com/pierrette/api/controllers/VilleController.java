package com.pierrette.api.controllers;

import com.pierrette.api.entities.Prefecture;
import com.pierrette.api.entities.Ville;
import com.pierrette.api.services.PrefectureService;
import com.pierrette.api.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ville")
public class VilleController {

    @Autowired
    private VilleService villeService;

    @GetMapping
    public List<Ville> getAllVilles() {
        return villeService.getAllVilles();
    }

   /* @GetMapping("/{idVilles}")
    public Optional<Ville> getVilleById(@PathVariable Integer id) {
        return VilleService.findById(id);
    }*/

    @PostMapping("/create")
    public Ville createVille(@RequestBody Ville ville) {
        return villeService.createVille(ville);
    }

    @PutMapping("/{id}")
    public Ville updateVille(@PathVariable Integer id, @RequestBody Ville ville) {
        // ville.setIdVille(id);
        return villeService.updateVille(id,ville);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVille(@PathVariable Integer id) {
        villeService.deleteVille(id);
        return ResponseEntity.ok("Ville avec l'ID "+id+" a été supprimé avec succès");
    }
}
