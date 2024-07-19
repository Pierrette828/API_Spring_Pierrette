package com.pierrette.api.controllers;

import com.pierrette.api.entities.Terminal;
import com.pierrette.api.services.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/terminals")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    @GetMapping
    public List<Terminal> getAllTerminals() {
        return terminalService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Terminal> getTerminalById(@PathVariable Integer id) {
        return terminalService.findById(id);
    }

    @PostMapping
    public Terminal createTerminal(@RequestBody Terminal terminal) {
        return terminalService.save(terminal);
    }

    @PutMapping("/{id}")
    public Terminal updateTerminal(@PathVariable Integer id, @RequestBody Terminal terminal) {
        terminal.setIdType(id);
        return terminalService.save(terminal);
    }

    @DeleteMapping("/{id}")
    public void deleteTerminal(@PathVariable Integer id) {
        terminalService.deleteById(id);
    }
}

