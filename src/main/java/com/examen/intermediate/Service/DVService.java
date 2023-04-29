package com.examen.intermediate.Service;

import com.examen.intermediate.DataTransfers.Objects.DVDto;

import java.util.List;

public interface DVService {


    DVDto addDV(DVDto dv);
    List<DVDto> getAllDVByAr(String articleId);
}
