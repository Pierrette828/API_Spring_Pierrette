package com.pierrette.api.repositories;

import com.pierrette.api.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface PaiementRepo extends JpaRepository<Paiement, Integer> {
    @Query(value = "select sum(montant) from paiement", nativeQuery = true)
    Long totalAccount();

    @Query(value = "SELECT SUM(montant) FROM paiement WHERE date_paiement >= CURRENT_DATE AND date_paiement < CURRENT_DATE + INTERVAL '1 day'", nativeQuery = true)
    Long totAccountByDay();

    @Query(value = "SELECT SUM(montant) FROM paiement WHERE TO_CHAR(date_paiement, 'YYYYMM') = TO_CHAR(CURRENT_TIMESTAMP, 'YYYYMM')", nativeQuery = true)
    Long totAccountByMonth();

    @Query(value = "SELECT SUM(montant) FROM paiement WHERE date_paiement BETWEEN :startOfWeek AND :endOfWeek", nativeQuery = true)
    Long totalAccountByWeek(@Param("startOfWeek") Date startOfWeek, @Param("endOfWeek") Date endOfWeek);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO paiement (date_paiement, montant, id_operateur, id_periodicite) VALUES (CURRENT_TIMESTAMP, :montant, :id_operateur, :id_periodicite)", nativeQuery = true)
    void insertion(@Param("montant") Integer montant,
                   @Param("id_operateur") Integer id_operateur, @Param("id_periodicite") Integer id_periodicite);

}

