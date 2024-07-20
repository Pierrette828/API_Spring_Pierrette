package com.pierrette.api.controllers;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.entities.Prefecture;
import com.pierrette.api.services.OperateurService;
import com.pierrette.api.services.PrefectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return prefectureService.getAllPrefectures();
    }

   /* @GetMapping("/{idPrefecture}")
    public Optional<Prefecture> getPrefectureById(@PathVariable Integer id) {
        return PrefectureService.findById(id);
    }*/

    @PostMapping("/create")
    public Prefecture createPrefecture(@RequestBody Prefecture prefecture) {
        return prefectureService.createPrefecture(prefecture);
    }

    @PutMapping("/{id}")
    public Prefecture updatePrefecture(@PathVariable Integer id, @RequestBody Prefecture prefecture) {
        // prefecture.setIdPrefecture(id);
        return prefectureService.updatePrefecture(id,prefecture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrefecture(@PathVariable Integer id) {
        prefectureService.deletePrefecture(id);
        return ResponseEntity.ok("Prefecture avec l'ID "+id+" a été supprimé avec succès");
    }
}
