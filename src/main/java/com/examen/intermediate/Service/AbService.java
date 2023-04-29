package com.examen.intermediate.Service;

import com.examen.intermediate.DataTransfers.Objects.AbDto;

import java.util.List;

public interface AbService {

    AbDto addAb(AbDto ab);
    List<AbDto> getAllFollowingsByUt(String id);
    List<AbDto> getAllFollowersByUt(String id);

}
