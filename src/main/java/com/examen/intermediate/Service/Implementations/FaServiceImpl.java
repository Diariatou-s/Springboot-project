package com.examen.intermediate.Service.Implementations;

import com.examen.intermediate.DataTransfers.Objects.FaDto;
import com.examen.intermediate.InputOutputs.Entities.FaEntity;
import com.examen.intermediate.InputOutputs.Repositories.FaRepo;
import com.examen.intermediate.Service.FaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class FaServiceImpl implements FaService {

    @Autowired
    FaRepo faRepo;


    @Override
    public FaDto addFa(FaDto fa) {
        FaEntity faEntity = new FaEntity();
        BeanUtils.copyProperties(fa, faEntity);

        FaEntity newFavorite = faRepo.save(faEntity);

        FaDto returnValue = new FaDto();
        BeanUtils.copyProperties(newFavorite, returnValue);

        return returnValue;
    }

    @Override
    public List<FaDto> getAllFaByUt(String userId) {
        List<FaDto> returnValue = new ArrayList<>();

        List<FaEntity> allFa =faRepo.findAll();
        List<FaEntity> allFaCreatedByTheUser = new LinkedList<>();

        for(int i=0;i<allFa.size();i++){

            if(allFa.get(i).getUserId().equals(userId)){

                allFaCreatedByTheUser.add(allFa.get(i));
            }
        }
        for (FaEntity faEntity : allFaCreatedByTheUser) {
            FaDto faDto = new FaDto();
            BeanUtils.copyProperties(faEntity, faDto);
            returnValue.add(faDto);
        }
        return returnValue;
    }
}
