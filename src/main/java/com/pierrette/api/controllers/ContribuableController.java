package com.pierrette.api.controllers;

import com.pierrette.api.entities.Contribuable;
import com.pierrette.api.entities.Operateur;
import com.pierrette.api.services.ContribuableService;
import com.pierrette.api.services.OperateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contribuable")
public class ContribuableController {

    @Autowired
    private ContribuableService contribuableService;

    @GetMapping
    public List<Contribuable> getAllOContribuables() {
        return contribuableService.getAllContribuable();
    }

   /* @GetMapping("/{idOContribuable}")
    public Optional<Contribuable> getContribuableById(@PathVariable Integer id) {
        return contribuableService.findById(id);
    }*/

    @PostMapping("/create")
    public Contribuable createContribuable(@RequestBody Contribuable contribuable) {
        return contribuableService.createContribuable(contribuable);
    }

    @PutMapping("/{id}")
    public Contribuable updateContribuable(@PathVariable Integer id, @RequestBody Contribuable contribuable) {
        // contribuable.setIdContribuable(id);
        return contribuableService.updateContribuable(id,contribuable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContribuable(@PathVariable Integer id) {
        contribuableService.deleteContribuable(id);
        return ResponseEntity.ok("Contribuable avec l'ID "+id+" a été supprimé avec succès");
    }
}
