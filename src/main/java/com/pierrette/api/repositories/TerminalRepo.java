package com.pierrette.api.repositories;

import com.pierrette.api.entities.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepo extends JpaRepository<Terminal, Integer> {
}

