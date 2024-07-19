package com.pierrette.api.controllers;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.services.OperateurService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return operateurService.findAll();
    }

    @GetMapping("/{idOperateur}")
    public Optional<Operateur> getOperateurById(@PathVariable Integer id) {
        return operateurService.findById(id);
    }

    @PostMapping("/create")
    public Operateur createOperateur(@RequestBody Operateur operateur) {
        return operateurService.save(operateur);
    }

    @PutMapping("/{idOperateur}")
    public Operateur updateOperateur(@PathVariable Integer id, @RequestBody Operateur operateur) {
       // operateur.setIdOperateur(id);
        return operateurService.save(operateur);
    }

    @DeleteMapping("/{idOperateur}")
    public void deleteOperateur(@PathVariable Integer id) {
        operateurService.deleteById(id);
    }
}
