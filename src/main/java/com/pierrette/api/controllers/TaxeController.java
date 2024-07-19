package com.pierrette.api.controllers;

import com.pierrette.api.entities.Taxe;
import com.pierrette.api.services.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taxes")
public class TaxeController {

    @Autowired
    private TaxeService taxeService;

    @GetMapping
    public List<Taxe> getAllTaxes() {
        return taxeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Taxe> getTaxeById(@PathVariable Integer id) {
        return taxeService.findById(id);
    }

    @PostMapping
    public Taxe createTaxe(@RequestBody Taxe taxe) {
        return taxeService.save(taxe);
    }

    @PutMapping("/{id}")
    public Taxe updateTaxe(@PathVariable Integer id, @RequestBody Taxe taxe) {
      //  taxe.setIdTaxe(id);
        return taxeService.save(taxe);
    }

    @DeleteMapping("/{id}")
    public void deleteTaxe(@PathVariable Integer id) {
        taxeService.deleteById(id);
    }
}
