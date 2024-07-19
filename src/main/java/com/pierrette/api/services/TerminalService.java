package com.pierrette.api.services;

import com.pierrette.api.entities.Terminal;
import com.pierrette.api.repositories.TerminalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TerminalService {

    @Autowired
    private TerminalRepo terminalRepository;

    public List<Terminal> findAll() {
        return terminalRepository.findAll();
    }

    public Optional<Terminal> findById(Integer id) {
        return terminalRepository.findById(id);
    }

    public Terminal save(Terminal terminal) {
        return terminalRepository.save(terminal);
    }

    public void deleteById(Integer id) {
        terminalRepository.deleteById(id);
    }
}
