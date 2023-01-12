package com.examen.intermediate.Service;

import com.examen.intermediate.DataTransfers.Objects.UVDto;

import java.util.List;

public interface UVService {

    UVDto addUV(UVDto uv);
    List<UVDto> getAllUVByAr(String articleId);

}
