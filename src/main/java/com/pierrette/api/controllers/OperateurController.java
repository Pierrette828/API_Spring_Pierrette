package com.pierrette.api.controllers;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.services.OperateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/operateurs")
public class OperateurController {

    @Autowired
    private OperateurService operateurService;

    @GetMapping
    public List<Operateur> getAllOperateurs() {
        return operateurService.getAllOperateurs();
    }

    @GetMapping("/{id}")
    public Optional<Operateur> getOperateurById(@PathVariable Integer id) {
        return Optional.ofNullable(operateurService.getOperateur(id));
    }

    @PostMapping
    public Operateur createOperateur(@RequestBody Operateur operateur) {
        return operateurService.createOperateur(operateur);
    }

    @PutMapping("/{id}")
    public Operateur updateOperateur(@PathVariable Integer id, @RequestBody Operateur operateur) {
       // operateur.setIdOperateur(id);
        return operateurService.createOperateur(operateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOperateur(@PathVariable Integer id) {
        operateurService.deleteOperateur(id);
        return ResponseEntity.ok("Operateur deleted");
    }
}
