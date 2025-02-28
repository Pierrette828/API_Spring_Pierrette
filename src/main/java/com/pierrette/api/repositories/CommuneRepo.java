package com.pierrette.api.repositories;

import com.pierrette.api.entities.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepo extends JpaRepository<Commune, Integer> {
}

