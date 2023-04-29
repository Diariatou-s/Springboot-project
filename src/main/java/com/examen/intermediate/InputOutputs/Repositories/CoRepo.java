package com.examen.intermediate.InputOutputs.Repositories;

import com.examen.intermediate.InputOutputs.Entities.CoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoRepo extends JpaRepository<CoEntity,Long> {

}
