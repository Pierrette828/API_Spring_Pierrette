package com.pierrette.api.controllers;

import com.pierrette.api.entities.Contribuable;
import com.pierrette.api.services.ContribuableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contribuables")
public class ContribuableController {

    @Autowired
    private ContribuableService contribuableService;

    @GetMapping
    public List<Contribuable> getAllContribuables() {
        return contribuableService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Contribuable> getContribuableById(@PathVariable Integer id) {
        return contribuableService.findById(id);
    }

    @PostMapping
    public Contribuable createContribuable(@RequestBody Contribuable contribuable) {
        return contribuableService.save(contribuable);
    }

    @PutMapping("/{id}")
    public Contribuable updateContribuable(@PathVariable Integer id, @RequestBody Contribuable contribuable) {
        contribuable.setIdContribuable(id);
        return contribuableService.save(contribuable);
    }

    @DeleteMapping("/{id}")
    public void deleteContribuable(@PathVariable Integer id) {
        contribuableService.deleteById(id);
    }
}
