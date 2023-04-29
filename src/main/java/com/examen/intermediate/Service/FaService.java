package com.examen.intermediate.Service;

import com.examen.intermediate.DataTransfers.Objects.FaDto;

import java.util.List;

public interface FaService {

    FaDto addFa(FaDto fa);
    List<FaDto> getAllFaByUt(String userId);

}
