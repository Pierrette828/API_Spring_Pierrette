package com.pierrette.api.repositories;
import com.pierrette.api.entities.Operateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;

@Repository
public interface OperateurRepo extends JpaRepository<Operateur, Integer> {
     Operateur findByUsername(String username);
     boolean existsByUsername(String username);
     @Query(value = "SELECT count(*) from operateur", nativeQuery = true)
     Integer countOperateur();

}
