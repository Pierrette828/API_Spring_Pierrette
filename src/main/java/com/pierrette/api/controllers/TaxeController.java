package com.pierrette.api.controllers;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.entities.Taxe;
import com.pierrette.api.services.OperateurService;
import com.pierrette.api.services.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taxe")
public class TaxeController {

    @Autowired
    private TaxeService taxeService;

    @GetMapping
    public List<Taxe> getAllTaxes() {
        return taxeService.getAllTaxes();
    }

   /* @GetMapping("/{idTaxe}")
    public Optional<Taxe> getTaxeById(@PathVariable Integer id) {
        return taxeService.findById(id);
    }*/

    @PostMapping("/create")
    public Taxe createTaxe(@RequestBody Taxe taxe) {
        return taxeService.createTaxe(taxe);
    }

    @PutMapping("/{id}")
    public Taxe updateTaxe(@PathVariable Integer id, @RequestBody Taxe taxe) {
        // taxe.setIdTaxe(id);
        return taxeService.updateTaxe(id,taxe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaxe(@PathVariable Integer id) {
        taxeService.deleteTaxe(id);
        return ResponseEntity.ok("Taxe avec l'ID "+id+" a été supprimé avec succès");
    }
}
