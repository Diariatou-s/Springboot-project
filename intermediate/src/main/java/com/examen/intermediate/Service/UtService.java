package com.examen.intermediate.Service;

import com.examen.intermediate.DataTransfers.Objects.UtDto;
import com.examen.intermediate.UserInterface.Model.Request.UtLoginRequest;

import java.util.List;

public interface UtService{
    UtDto loginUt(UtLoginRequest ut);
    UtDto createUt(UtDto ut);
    UtDto getUserByUserId(String userId);
    UtDto updateUserById(String userId, UtDto utDto);
    List<UtDto> getUsers(int page, int limit);
}
