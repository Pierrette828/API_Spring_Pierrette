package com.pierrette.api.repositories;
import com.pierrette.api.entities.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeRepo extends JpaRepository<Taxe, Integer> {
}
