package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IOperateurService {
    public List<Operateur> getAllOperateurs();
    public Operateur createOperateur(Operateur operateur);
    public Operateur updateOperateur(Integer id);
    public void deleteOperateur(Integer id);


}
