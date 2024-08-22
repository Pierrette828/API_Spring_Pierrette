package com.pierrette.api.controllers;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.requests.SignUp;
import com.pierrette.api.services.AuthentificationService;
import com.pierrette.api.services.OperateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth/operateur")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:50085"})
public class OperateurController {

    private final OperateurService operateurService;
    private final AuthentificationService authentificationService;

    @GetMapping("/list")
    public List<Operateur> getAllOperateurs() {
        return operateurService.getAllOperateurs();
    }

    @GetMapping("/get/{id}")
    public Optional<Operateur> getOperateurById(@PathVariable Integer id) {
        return operateurService.getOperateur(id);
    }

    @PostMapping("/add")
    public String createOperateur(@RequestBody SignUp request) {
//        return operateurService.createOperateur(operateur);
        return authentificationService.signUp(request);
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
    @GetMapping("/count")
    public Integer countOperateurs(){
        return operateurService.getOperateurs();

    }
}
