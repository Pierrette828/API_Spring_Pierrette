package com.pierrette.api.controllers;

import com.pierrette.api.entities.Paiement;
import com.pierrette.api.services.PaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth/paiement")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58349"})
public class PaiementController {


    private final PaiementService paiementService;

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/{id}")
    public Optional<Paiement> getPaiementById(@PathVariable Integer id) {
        return paiementService.getPaiement(id);
    }

    @PostMapping("/create")
    public Paiement createPaiement(@RequestBody Paiement paiement) {
        return paiementService.createPaiement(paiement);
    }

    @PutMapping("/{id}")
    public Paiement updatePaiement(@PathVariable Integer id, @RequestBody Paiement paiement) {

        return paiementService.updatePaiement(id, paiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaiement(@PathVariable Integer id) {
        paiementService.deletePaiement(id);
        return ResponseEntity.ok("Paiement avec l'ID " + id + " a été supprimé avec succès");
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalPaiements() {
        Long total = paiementService.totalPaiements();
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

        @GetMapping("/total/day")
    public ResponseEntity<Long> getTotalPaiementsByDay() {

        Long totalByDay = paiementService.totalPaiementsByDay();
        if (totalByDay == null){
            totalByDay = 0L;
        }
        return new ResponseEntity<>(totalByDay, HttpStatus.OK);
    }
//    @GetMapping("/total/day")
//    public ResponseEntity<Long> getTotalPaiementsByDay() {
//        Long totalPaiements = paiementService.totalPaiementsByDay();
//        if (totalPaiements == null) {
//            // Log or handle error
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(totalPaiements);
//    }

    @GetMapping("/total/month")
    public ResponseEntity<Long> getTotalPaiementsByMonth() {
        Long totalByMonth = paiementService.totalPaiementsByMonth();
        if (totalByMonth == null){
            totalByMonth = 0L;
        }
        return new ResponseEntity<>(totalByMonth, HttpStatus.OK);
    }

    @GetMapping("/total/week")
    public ResponseEntity<Long> getTotalPaiementsByWeek(@RequestParam(value = "date", required = false) String dateString) {
        Calendar calendar = Calendar.getInstance();
        if (dateString != null) {
            // Parse the date string if provided (assumed format: yyyy-MM-dd)
            String[] parts = dateString.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]) - 1; // Calendar months are 0-based
            int day = Integer.parseInt(parts[2]);
            calendar.set(year, month, day);
        }
        Long totalByWeek = paiementService.totalPaiementsByWeek(calendar);
        if (totalByWeek == null){
            totalByWeek = 0L;
        }
        return new ResponseEntity<>(totalByWeek, HttpStatus.OK);
    }
}
