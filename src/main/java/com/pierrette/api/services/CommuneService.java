package com.pierrette.api.services;

import com.pierrette.api.entities.Commune;
import com.pierrette.api.repositories.CommuneRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneService {

    @Autowired
    private CommuneRepo communeRepository;

    public CommuneService(CommuneRepo communeRepository) {
        this.communeRepository = communeRepository;
    }


    public List<Commune> getAllCommunes() {
        return communeRepository.findAll();
    }

    public Commune createCommune(Commune commune) {
        return communeRepository.save(commune);
    }

    public Commune updateCommune(Integer id, Commune communeUpdate) {
        Commune communeExiste = communeRepository.findById(id).orElse(null);
        assert communeExiste != null;
        communeExiste.setLibelleCommune(communeUpdate.getLibelleCommune());
        communeExiste.setLibellePrefecture(communeUpdate.getLibellePrefecture());

        return communeRepository.save(communeExiste);

    }

    public void deleteCommune(Integer id) {
        if (id != 0) {
            communeRepository.deleteById(id);
        }
    }

    public Integer countCommune(){

        List<Commune> communeList=  getAllCommunes();
        return communeList.size();
    }

    public Commune getCommune(Integer idCommune) {
        return communeRepository.findById(idCommune).orElse(null);
    }

}


