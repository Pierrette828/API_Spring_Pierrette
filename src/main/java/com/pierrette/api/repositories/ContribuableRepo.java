package com.pierrette.api.repositories;
import com.pierrette.api.entities.Contribuable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContribuableRepo extends JpaRepository<Contribuable, Integer> {
}

