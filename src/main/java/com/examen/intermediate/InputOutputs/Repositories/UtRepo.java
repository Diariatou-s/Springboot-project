package com.examen.intermediate.InputOutputs.Repositories;

import com.examen.intermediate.InputOutputs.Entities.UtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtRepo extends JpaRepository<UtEntity,Long> {
    UtEntity findByEmail(String email);
    UtEntity findByUserId(String userId);
}
