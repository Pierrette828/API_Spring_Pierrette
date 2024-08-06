package com.pierrette.api.controllers;

import com.pierrette.api.entities.Terminal;
import com.pierrette.api.services.TerminalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/terminal")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58349"})
public class TerminalController {

    private final TerminalService terminalService;

    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @GetMapping
    public List<Terminal> getAllTerminals() {
        return terminalService.getAllTerminals();
    }

    @GetMapping("/{id}")
    public Optional<Terminal> getTerminalById(@PathVariable Integer id) {
        return terminalService.getTerminal(id);
    }

    @PostMapping("/create")
    public Terminal createTerminal(@RequestBody Terminal terminal) {
        return terminalService.createTerminal(terminal);
    }

    @PutMapping("/{id}")
    public Terminal updateTerminal(@PathVariable Integer id, @RequestBody Terminal terminal) {
        return terminalService.updateTerminal(id,terminal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTerminal(@PathVariable Integer id) {
        terminalService.deleteTerminal(id);
        return ResponseEntity.ok("terminal avec l'ID "+id+" a été supprimé avec succès");
    }
}
