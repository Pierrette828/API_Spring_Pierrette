package com.pierrette.api.controllers;

import com.pierrette.api.entities.Taxe;
import com.pierrette.api.services.TaxeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/taxe")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58349"})
public class TaxeController {

    private final TaxeService taxeService;

    public TaxeController(TaxeService taxeService) {
        this.taxeService = taxeService;
    }

    @GetMapping
    public List<Taxe> getAllTaxes() {
        return taxeService.getAllTaxes();
    }

    @GetMapping("/{id}")
    public Optional<Taxe> getTaxeById(@PathVariable Integer id) {
        return taxeService.getTaxe(id);
    }

    @PostMapping("/create")
    public Taxe createTaxe(@RequestBody Taxe taxe) {
        return taxeService.createTaxe(taxe);
    }

    @PutMapping("/{id}")
    public Taxe updateTaxe(@PathVariable Integer id, @RequestBody Taxe taxe) {
        return taxeService.updateTaxe(id, taxe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaxe(@PathVariable Integer id) {
        taxeService.deleteTaxe(id);
        return ResponseEntity.ok("Taxe avec l'ID " + id + " a été supprimé avec succès");
    }
}
