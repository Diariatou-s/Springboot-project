package com.examen.intermediate.Service.Implementations;

import com.examen.intermediate.DataTransfers.Objects.CaDto;
import com.examen.intermediate.InputOutputs.Entities.CaEntity;
import com.examen.intermediate.InputOutputs.Repositories.CaRepo;
import com.examen.intermediate.Service.CaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaServiceImpl implements CaService {

    @Autowired
    CaRepo caRepo;

    @Override
    public List<CaDto> getAllCa() {
        List<CaDto> returnValue = new ArrayList<>();

        List<CaEntity> allCa = caRepo.findAll();

        for (CaEntity caEntity : allCa) {
            CaDto caDto = new CaDto();
            BeanUtils.copyProperties(caEntity, caDto);
            returnValue.add(caDto);
        }

        return returnValue;
    }

    @Override
    public CaDto getCaById(Long id) {
        CaDto returnValue = new CaDto();

        CaEntity caEntity = caRepo.findById(id).orElseThrow();
        BeanUtils.copyProperties(caEntity, returnValue);

        return returnValue;
    }
}
