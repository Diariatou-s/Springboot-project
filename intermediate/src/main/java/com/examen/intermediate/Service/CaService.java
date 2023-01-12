package com.examen.intermediate.Service;

import com.examen.intermediate.DataTransfers.Objects.CaDto;

import java.util.List;

public interface CaService {

    List<CaDto> getAllCa();
    CaDto getCaById(Long id);
}
