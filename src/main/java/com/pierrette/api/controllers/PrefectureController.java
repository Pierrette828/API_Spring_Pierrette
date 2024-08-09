package com.pierrette.api.controllers;

import com.pierrette.api.entities.Prefecture;
import com.pierrette.api.services.PrefectureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/prefectures")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58349"})
public class PrefectureController {

    private final PrefectureService prefectureService;

    public PrefectureController(PrefectureService prefectureService) {
        this.prefectureService = prefectureService;
    }

    @GetMapping
    public List<Prefecture> getAllPrefectures() {
        return prefectureService.getAllPrefectures();
    }

    @GetMapping("/{id}")
    public Optional<Prefecture> getPrefectureById(@PathVariable Integer id) {
        return prefectureService.getPrefecture(id);
    }

    @PostMapping("/create")
    public Prefecture createPrefecture(@RequestBody Prefecture prefecture) {
        return prefectureService.createPrefecture(prefecture);
    }

    @PutMapping("/{id}")
    public Prefecture updatePrefecture(@PathVariable Integer id, @RequestBody Prefecture prefecture) {

        return prefectureService.updatePrefecture(id,prefecture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrefecture(@PathVariable Integer id) {
        prefectureService.deletePrefecture(id);
        return ResponseEntity.ok("Prefecture avec l'ID "+id+" a été supprimé avec succès");
    }
}
