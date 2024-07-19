package com.pierrette.api.repositories;
import com.pierrette.api.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepo extends JpaRepository<Ville, Integer> {
}
