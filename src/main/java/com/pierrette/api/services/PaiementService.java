package com.pierrette.api.services;

import com.pierrette.api.entities.Paiement;
import com.pierrette.api.repositories.PaiementRepo;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    private final PaiementRepo paiementRepository;

    public PaiementService(PaiementRepo paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Paiement createPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public Paiement updatePaiement(Integer id, Paiement paiementUpdate) {
        Paiement paiementExiste = paiementRepository.findById(id).orElse(null);
        assert paiementExiste != null;
        paiementExiste.setDatePaiement(paiementUpdate.getDatePaiement());
        paiementExiste.setMontant(paiementUpdate.getMontant());

        return paiementRepository.save(paiementExiste);
    }

    public void deletePaiement(Integer id) {
        if (id != 0) {
            paiementRepository.deleteById(id);
        }
    }

    public Optional<Paiement> getPaiement(Integer idPaiement) {
        return paiementRepository.findById(idPaiement);
    }

    public Long totalPaiements() {
        return paiementRepository.totalAccount();
    }
    public Long totalPaiementsByDay() {
        return paiementRepository.totAccountByDay();
    }
    public Long totalPaiementsByMonth() {
        return paiementRepository.totAccountByMonth();
    }

    public Long totalPaiementsByWeek(Calendar calendar) {
        // Set the calendar to the first day of the week (typically Sunday or Monday)
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        Date startOfWeek = calendar.getTime();

        // Move the calendar to the last day of the week
        calendar.add(Calendar.DAY_OF_WEEK, 6);
        Date endOfWeek = calendar.getTime();

        // Convert the dates to SQL Date format
        java.sql.Date sqlStartOfWeek = new java.sql.Date(startOfWeek.getTime());
        java.sql.Date sqlEndOfWeek = new java.sql.Date(endOfWeek.getTime());

        // Query the database to get the total payments for the week
        return paiementRepository.totalAccountByWeek(sqlStartOfWeek, sqlEndOfWeek);
    }
}
