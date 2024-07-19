package com.pierrette.api.repositories;

import com.pierrette.api.entities.Prefecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefectureRepo extends JpaRepository<Prefecture, Integer> {
}
