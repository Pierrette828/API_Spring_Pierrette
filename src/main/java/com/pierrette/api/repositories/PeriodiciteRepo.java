package com.pierrette.api.repositories;

import com.pierrette.api.entities.Periodicite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodiciteRepo extends JpaRepository<Periodicite, Integer> {
}

