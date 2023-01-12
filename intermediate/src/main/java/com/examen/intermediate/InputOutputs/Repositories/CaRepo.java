package com.examen.intermediate.InputOutputs.Repositories;

import com.examen.intermediate.InputOutputs.Entities.CaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaRepo extends JpaRepository<CaEntity,Long> {

}
