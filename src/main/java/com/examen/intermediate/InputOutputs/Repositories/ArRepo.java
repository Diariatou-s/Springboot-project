package com.examen.intermediate.InputOutputs.Repositories;

import com.examen.intermediate.InputOutputs.Entities.ArEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArRepo extends JpaRepository<ArEntity,Long> {

    ArEntity findByArticleId(String id);
}
