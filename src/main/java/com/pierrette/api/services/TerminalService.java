package com.pierrette.api.services;

import com.pierrette.api.entities.Terminal;
import com.pierrette.api.repositories.TerminalRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalService {

    private final TerminalRepo terminalRepository;

    public TerminalService(TerminalRepo terminalRepository) {
        this.terminalRepository = terminalRepository;
    }


    public List<Terminal> getAllTerminals() {
        return terminalRepository.findAll();
    }

    public Terminal createTerminal(Terminal terminal) {
        return terminalRepository.save(terminal);
    }

    public Terminal updateTerminal(Integer id, Terminal terminalUpdate) {
        Terminal terminalExiste = terminalRepository.findById(id).orElse(null);
        assert terminalExiste != null;
        terminalExiste.setModel(terminalUpdate.getModel());
        return terminalRepository.save(terminalExiste);


    }

    public void deleteTerminal(Integer id) {
        if (id != 0) {
            terminalRepository.deleteById(id);
        }
    }

    public Optional<Terminal> getTerminal(Integer idTerminal) {
        return terminalRepository.findById(idTerminal);
    }

}