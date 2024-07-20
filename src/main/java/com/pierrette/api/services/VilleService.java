package com.pierrette.api.services;

import com.pierrette.api.entities.Prefecture;
import com.pierrette.api.entities.Ville;
import com.pierrette.api.repositories.PrefectureRepo;
import com.pierrette.api.repositories.VilleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VilleService {

    @Autowired
    private VilleRepo villeRepository;

    public List<Ville> getAllVilles(){
        return villeRepository.findAll();
    }

    public Ville createVille(Ville ville){
        return villeRepository.save(ville);
    }

    public Ville updateVille(Integer id, Ville villeUpdate){
        Ville villeExiste = villeRepository.findById(id).orElse(null);
        if (villeExiste!=null){
            villeExiste.setLibelleVille(villeUpdate.getLibelleVille());
        } return villeExiste;
    }

    public String deleteVille(Integer id) {
        if(id!=0){
            villeRepository.deleteById(id);
            return "Suppression";
        }
        return null;
    }

    public Ville getVille(Integer idVille){
        return villeRepository.findById(idVille).get();
    }

}