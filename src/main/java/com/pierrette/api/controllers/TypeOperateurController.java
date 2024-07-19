package com.pierrette.api.controllers;

import com.pierrette.api.entities.Type_operateur;
import com.pierrette.api.services.TypeOperateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type-operateurs")
public class TypeOperateurController {

    @Autowired
    private TypeOperateurService typeOperateurService;

    @GetMapping
    public List<Type_operateur> getAllTypeOperateurs() {
        return typeOperateurService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Type_operateur> getTypeOperateurById(@PathVariable Integer id) {
        return typeOperateurService.findById(id);
    }

    @PostMapping
    public Type_operateur createTypeOperateur(@RequestBody Type_operateur typeOperateur) {
        return typeOperateurService.save(typeOperateur);
    }

    @PutMapping("/{id}")
    public Type_operateur updateTypeOperateur(@PathVariable Integer id, @RequestBody Type_operateur typeOperateur) {
        typeOperateur.setIdTypeOperateur(id);
        return typeOperateurService.save(typeOperateur);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeOperateur(@PathVariable Integer id) {
        typeOperateurService.deleteById(id);
    }
}

