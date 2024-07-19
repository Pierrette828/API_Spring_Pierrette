package com.pierrette.api.repositories;

import com.pierrette.api.entities.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalisationRepo extends JpaRepository<Localisation, Integer> {
}

