package com.pierrette.api.repositories;
import com.pierrette.api.entities.Type_operateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOperateurRepo extends JpaRepository<Type_operateur, Integer> {
}

