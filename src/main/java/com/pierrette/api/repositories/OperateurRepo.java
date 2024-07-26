package com.pierrette.api.repositories;
import com.pierrette.api.entities.Operateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperateurRepo extends JpaRepository<Operateur, Integer> {
     Operateur findByUsername(String username);

}
