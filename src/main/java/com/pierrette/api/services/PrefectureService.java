package com.pierrette.api.services;

import com.pierrette.api.entities.Prefecture;
import com.pierrette.api.repositories.PrefectureRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrefectureService {

    private final PrefectureRepo prefectureRepository;

    public PrefectureService(PrefectureRepo prefectureRepository) {
        this.prefectureRepository = prefectureRepository;
    }


    public List<Prefecture> getAllPrefectures() {
        return prefectureRepository.findAll();
    }

    public Prefecture createPrefecture(Prefecture prefecture) {
        return prefectureRepository.save(prefecture);
    }

    public Prefecture updatePrefecture(Integer id, Prefecture prefectureUpdate) {
        Prefecture prefectureExiste = prefectureRepository.findById(id).orElse(null);
        assert prefectureExiste != null;
        prefectureExiste.setLibellePrefecture(prefectureUpdate.getLibellePrefecture());
        prefectureExiste.setLibelleVille(prefectureUpdate.getLibelleVille());
        return prefectureRepository.save(prefectureExiste);

    }

    public void deletePrefecture(Integer id) {
        if (id != 0) {
            prefectureRepository.deleteById(id);
        }
    }

    public Optional<Prefecture> getPrefecture(Integer idPrefecture) {
        return prefectureRepository.findById(idPrefecture);
    }

}
