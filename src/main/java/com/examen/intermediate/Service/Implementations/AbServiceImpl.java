package com.examen.intermediate.Service.Implementations;

import com.examen.intermediate.DataTransfers.Objects.AbDto;
import com.examen.intermediate.InputOutputs.Entities.AbEntity;
import com.examen.intermediate.InputOutputs.Repositories.AbRepo;
import com.examen.intermediate.Service.AbService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class AbServiceImpl implements AbService {

    @Autowired
    AbRepo abRepo;

    @Override
    public AbDto addAb(AbDto ab) {
        AbEntity abEntity = new AbEntity();
        BeanUtils.copyProperties(ab, abEntity);

        AbEntity newFollowing = abRepo.save(abEntity);

        AbDto returnValue = new AbDto();
        BeanUtils.copyProperties(newFollowing, returnValue);

        return returnValue;
    }

    @Override
    public List<AbDto> getAllFollowingsByUt(String id) {
        List<AbDto> returnValue = new ArrayList<>();

        List<AbEntity> allAb = abRepo.findAll();
        List<AbEntity> allAbByUt = new LinkedList<>();

        for(int i=0;i<allAb.size();i++){

            if(allAb.get(i).getSuivantId().equals(id)){

                allAbByUt.add(allAb.get(i));
            }
        }
        for (AbEntity abEntity : allAbByUt) {
            AbDto abDto = new AbDto();
            BeanUtils.copyProperties(abEntity, abDto);
            returnValue.add(abDto);
        }

        return returnValue;
    }

    @Override
    public List<AbDto> getAllFollowersByUt(String id) {
        List<AbDto> returnValue = new ArrayList<>();

        List<AbEntity> allAb = abRepo.findAll();
        List<AbEntity> allAbByUt = new LinkedList<>();

        for(int i=0;i<allAb.size();i++){

            if(allAb.get(i).getSuiviId().equals(id)){

                allAbByUt.add(allAb.get(i));
            }
        }
        for (AbEntity abEntity : allAbByUt) {
            AbDto abDto = new AbDto();
            BeanUtils.copyProperties(abEntity, abDto);
            returnValue.add(abDto);
        }

        return returnValue;
    }
}
