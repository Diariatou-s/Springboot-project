package com.examen.intermediate.UserInterface.Controllers;

import com.examen.intermediate.DataTransfers.Objects.CaDto;
import com.examen.intermediate.Service.CaService;
import com.examen.intermediate.UserInterface.Model.Response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ca")
public class CaController {

    @Autowired
    CaService caService;

    @GetMapping
    public List<CaDto> getAllCa(){
        List<CaDto> returnValue = new ArrayList<>();

        List<CaDto> topics = caService.getAllCa();

        for (CaDto caDto : topics) {
            CaDto caModel = new CaDto();
            BeanUtils.copyProperties(caDto, caModel);
            returnValue.add(caModel);
        }

        return returnValue;
    }

    @GetMapping(path="/{id}")
    public CaRest getCaById(@PathVariable Long id){
        CaRest returnValue = new CaRest();

        CaDto caDto = caService.getCaById(id);

        BeanUtils.copyProperties(caDto, returnValue);

        return returnValue;
    }
}
