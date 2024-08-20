package com.pierrette.api.services;

import com.pierrette.api.entities.Operateur;
import com.pierrette.api.entities.Paiement;
import com.pierrette.api.entities.Periodicite;
import com.pierrette.api.repositories.OperateurRepo;
import com.pierrette.api.repositories.PaiementRepo;
import com.pierrette.api.repositories.PeriodiciteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class PaiementService {

    private final PaiementRepo paiementRepository;
    private final OperateurRepo operateurRepository;
    private final PeriodiciteRepo periodiciteRepository;


    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Paiement createPaiement(Paiement paiement) {
        Operateur operateur = operateurRepository.findByUsername(paiement.getOperateur().getUsername());
        if (operateur == null) {
            throw new IllegalArgumentException("Operateur non trouvé avec son nom d'utilisateur");
        }
        Periodicite periodicite = periodiciteRepository.findById(paiement.getPeriodicite().getIdValidite())
                .orElseThrow(() -> new IllegalArgumentException("Periodicité non trouvé"));
        paiement.setOperateur(operateur);
        paiement.setPeriodicite(periodicite);
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


    public void insertPaiement(Integer montant, Integer idOperateur, Integer idPeriodicite) {
        paiementRepository.insertion( montant, idOperateur, idPeriodicite);
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

//    public Long totalPaiementsByWeek(Calendar calendar) {
//        // Set the calendar to the first day of the week (typically Sunday or Monday)
//        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
//        Date startOfWeek = calendar.getTime();
//
//        // Move the calendar to the last day of the week
//        calendar.add(Calendar.DAY_OF_WEEK, 6);
//        Date endOfWeek = calendar.getTime();
//
//        // Convert the dates to SQL Date format
//        java.sql.Date sqlStartOfWeek = new java.sql.Date(startOfWeek.getTime());
//        java.sql.Date sqlEndOfWeek = new java.sql.Date(endOfWeek.getTime());
//
//        // Query the database to get the total payments for the week
//        return paiementRepository.totalAccountByWeek(sqlStartOfWeek, sqlEndOfWeek);
//    }


    public Long getTotalAccountByWeek(Date startOfWeek, Date endOfWeek) {
        return paiementRepository.totalAccountByWeek(startOfWeek, endOfWeek);
    }


}
