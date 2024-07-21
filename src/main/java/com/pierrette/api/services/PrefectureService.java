package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.entities.Prefecture;
import com.pierrette.api.repositories.OperateurRepo;
import com.pierrette.api.repositories.PrefectureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrefectureService {

    @Autowired
    private PrefectureRepo prefectureRepository;


    public List<Prefecture> getAllPrefectures(){
        return prefectureRepository.findAll();
    }

    public Prefecture createPrefecture(Prefecture prefecture){
        return prefectureRepository.save(prefecture);
    }

    public Prefecture updatePrefecture(Integer id, Prefecture prefectureUpdate){
        Prefecture prefectureExiste = prefectureRepository.findById(id).orElse(null);
        if (prefectureExiste!=null){
            prefectureExiste.setLibellePrefecture(prefectureUpdate.getLibellePrefecture());
            prefectureExiste.setLibelleVille(prefectureUpdate.getLibelleVille());
            Prefecture prefectureAjour = prefectureRepository.save(prefectureExiste);
        } return prefectureExiste;
    }

    public String deletePrefecture(Integer id) {
        if(id!=0){
            prefectureRepository.deleteById(id);
            return "Suppression";
        }
        return null;
    }

    public Prefecture getPrefecture(Integer idPrefecture){
        return prefectureRepository.findById(idPrefecture).get();
    }

}
