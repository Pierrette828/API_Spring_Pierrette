package com.pierrette.api.services;

import com.pierrette.api.entities.Taxe;
import com.pierrette.api.entities.Terminal;
import com.pierrette.api.repositories.TaxeRepo;
import com.pierrette.api.repositories.TerminalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TerminalService {

    @Autowired
    private TerminalRepo terminalRepository;


    public List<Terminal> getAllTerminals(){
        return terminalRepository.findAll();
    }

    public Terminal createTerminal(Terminal  terminal){
        return terminalRepository.save( terminal);
    }

    public Terminal updateTerminal(Integer id, Terminal  terminalUpdate){
        Terminal terminalExiste = terminalRepository.findById(id).orElse(null);
        if (terminalExiste!=null){
            terminalExiste.setModel( terminalUpdate.getModel());
            Terminal  terminalAjour =  terminalRepository.save( terminalExiste);

        } return  terminalExiste;
    }

    public String deleteTerminal(Integer id) {
        if(id!=0){
            terminalRepository.deleteById(id);
            return "Suppression";
        }
        return null;
    }

    public Terminal getTerminal(Integer idTerminal){
        return terminalRepository.findById(idTerminal).get();
    }

}