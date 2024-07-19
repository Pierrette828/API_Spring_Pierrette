package com.pierrette.api.services;

import com.pierrette.api.entities.Prefecture;
import com.pierrette.api.repositories.PrefectureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrefectureService {

    @Autowired
    private PrefectureRepo prefectureRepository;

    public List<Prefecture> findAll() {
        return prefectureRepository.findAll();
    }

    public Optional<Prefecture> findById(Integer id) {
        return prefectureRepository.findById(id);
    }

    public Prefecture save(Prefecture prefecture) {
        return prefectureRepository.save(prefecture);
    }

    public void deleteById(Integer id) {
        prefectureRepository.deleteById(id);
    }
}

