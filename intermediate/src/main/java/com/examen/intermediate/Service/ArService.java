package com.examen.intermediate.Service;

import com.examen.intermediate.DataTransfers.Objects.ArDto;

import java.util.List;

public interface ArService {

    ArDto addAr(ArDto ar);
    List<ArDto> getAllArByAuthor(String auteurId);
    List<ArDto> getAllArByTopic(Long categorieId);
    List<ArDto> getAllAr(int page, int limit);
    ArDto updateAr(ArDto ar);
    ArDto getArById(String id);
    void deleteArById(String id);
}
