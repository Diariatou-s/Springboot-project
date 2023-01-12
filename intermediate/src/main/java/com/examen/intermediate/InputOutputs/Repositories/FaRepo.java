package com.examen.intermediate.InputOutputs.Repositories;

import com.examen.intermediate.InputOutputs.Entities.FaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaRepo extends JpaRepository<FaEntity,Long> {

}
