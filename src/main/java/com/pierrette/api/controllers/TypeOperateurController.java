package com.pierrette.api.controllers;

import com.pierrette.api.entities.Type_operateur;
import com.pierrette.api.services.TypeOperateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/typeoperateur")
public class TypeOperateurController {

    private final TypeOperateurService typeOperateurService;

    public TypeOperateurController(TypeOperateurService typeOperateurService) {
        this.typeOperateurService = typeOperateurService;
    }

    @GetMapping
    public List<Type_operateur> getAllTypeOperateurs() {
        return typeOperateurService.getAllTypeOperateurs();
    }

    @GetMapping("/{id}")
    public Optional<Type_operateur> getTypeOperateurById(@PathVariable Integer id) {
        return typeOperateurService.getTypeOperateur(id);
    }

    @PostMapping("/create")
    public Type_operateur createTypeOperateur(@RequestBody Type_operateur typeOperateur) {
        return typeOperateurService.createTypeOperateur(typeOperateur);
    }

    @PutMapping("/{id}")
    public Type_operateur updateTypeOperateur(@PathVariable Integer id, @RequestBody Type_operateur typeOperateur) {
        return typeOperateurService.updateTypeOperateur(id,typeOperateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTypeOperateur(@PathVariable Integer id) {
        typeOperateurService.deleteTypeOperateur(id);
        return ResponseEntity.ok("TypeOperateur avec l'ID "+id+" a été supprimé avec succès");
    }
}
