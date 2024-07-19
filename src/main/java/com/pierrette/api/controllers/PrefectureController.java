package com.pierrette.api.controllers;

import com.pierrette.api.entities.Prefecture;
import com.pierrette.api.services.PrefectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prefectures")
public class PrefectureController {

    @Autowired
    private PrefectureService prefectureService;

    @GetMapping
    public List<Prefecture> getAllPrefectures() {
        return prefectureService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Prefecture> getPrefectureById(@PathVariable Integer id) {
        return prefectureService.findById(id);
    }

    @PostMapping
    public Prefecture createPrefecture(@RequestBody Prefecture prefecture) {
        return prefectureService.save(prefecture);
    }

    @PutMapping("/{id}")
    public Prefecture updatePrefecture(@PathVariable Integer id, @RequestBody Prefecture prefecture) {
        prefecture.setIdPrefecture(id);
        return prefectureService.save(prefecture);
    }

    @DeleteMapping("/{id}")
    public void deletePrefecture(@PathVariable Integer id) {
        prefectureService.deleteById(id);
    }
}
