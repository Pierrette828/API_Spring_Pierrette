package com.pierrette.api.repositories;

import com.pierrette.api.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

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

}

