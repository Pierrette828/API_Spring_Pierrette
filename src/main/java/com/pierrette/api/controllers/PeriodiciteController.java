package com.pierrette.api.controllers;

import com.pierrette.api.entities.Periodicite;
import com.pierrette.api.services.PeriodiciteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/periodicites")
public class PeriodiciteController {

    @Autowired
    private PeriodiciteService periodiciteService;

    @GetMapping
    public List<Periodicite> getAllPeriodicites() {
        return periodiciteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Periodicite> getPeriodiciteById(@PathVariable Integer id) {
        return periodiciteService.findById(id);
    }

    @PostMapping
    public Periodicite createPeriodicite(@RequestBody Periodicite periodicite) {
        return periodiciteService.save(periodicite);
    }

    @PutMapping("/{id}")
    public Periodicite updatePeriodicite(@PathVariable Integer id, @RequestBody Periodicite periodicite) {
        periodicite.setIdValidite(id);
        return periodiciteService.save(periodicite);
    }

    @DeleteMapping("/{id}")
    public void deletePeriodicite(@PathVariable Integer id) {
        periodiciteService.deleteById(id);
    }
}

