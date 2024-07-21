package com.pierrette.api.repositories;

import com.pierrette.api.entities.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbUserRepo extends JpaRepository<DBUser, Integer> {
    public DBUser findByUsername(String username);
}
