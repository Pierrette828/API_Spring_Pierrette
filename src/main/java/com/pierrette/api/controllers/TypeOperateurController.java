package com.pierrette.api.controllers;

import com.pierrette.api.entities.Taxe;
import com.pierrette.api.entities.Type_operateur;
import com.pierrette.api.entities.Type_operateur;
import com.pierrette.api.services.TaxeService;
import com.pierrette.api.services.TypeOperateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/typeoperateur")
public class TypeOperateurController {

    @Autowired
    private TypeOperateurService typeOperateurService;

    @GetMapping
    public List<Type_operateur> getAllTypeOperateurs() {
        return typeOperateurService.getAllTypeOperateurs();
    }

   /* @GetMapping("/{idTypeOperateur}")
    public Optional<TypeOperateur> getTypeOperateurById(@PathVariable Integer id) {
        return TypeOperateurService.findById(id);
    }*/

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
