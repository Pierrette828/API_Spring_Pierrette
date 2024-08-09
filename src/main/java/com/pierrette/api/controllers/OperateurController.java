package com.pierrette.api.controllers;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.services.OperateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/operateur")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58349"})
public class OperateurController {

    private final OperateurService operateurService;

    public OperateurController(OperateurService operateurService) {
        this.operateurService = operateurService;
    }

    @GetMapping("/list")
    public List<Operateur> getAllOperateurs() {
        return operateurService.getAllOperateurs();
    }

    @GetMapping("/get/{id}")
    public Optional<Operateur> getOperateurById(@PathVariable Integer id) {
        return operateurService.getOperateur(id);
    }

    @PostMapping("/add")
    public Operateur createOperateur(@RequestBody Operateur operateur) {
        return operateurService.createOperateur(operateur);
    }

    @PutMapping("/{id}")
    public Operateur updateOperateur(@PathVariable Integer id, @RequestBody Operateur operateur) {

        return operateurService.updateOperateur(id, operateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOperateur(@PathVariable Integer id) {
        operateurService.deleteOperateur(id);
        return ResponseEntity.ok("Operateur deleted");
    }
}
