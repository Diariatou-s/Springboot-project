package com.examen.intermediate.Service;

import com.examen.intermediate.DataTransfers.Objects.CoDto;

import java.util.List;

public interface CoService {

    CoDto addCo(CoDto co);
    List<CoDto> allCoByAr(String articleId);
}
