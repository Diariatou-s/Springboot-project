package com.examen.intermediate.Service.Implementations;

import com.examen.intermediate.DataTransfers.Objects.DVDto;
import com.examen.intermediate.InputOutputs.Entities.DVEntity;
import com.examen.intermediate.InputOutputs.Repositories.DVRepo;
import com.examen.intermediate.Service.DVService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class DVServiceImpl implements DVService {

    @Autowired
    DVRepo dvRepo;


    @Override
    public DVDto addDV(DVDto dv) {
        DVEntity dvEntity = new DVEntity();
        BeanUtils.copyProperties(dv, dvEntity);

        DVEntity newDownvote = dvRepo.save(dvEntity);

        DVDto returnValue = new DVDto();
        BeanUtils.copyProperties(newDownvote, returnValue);

        return returnValue;
    }

    @Override
    public List<DVDto> getAllDVByAr(String articleId) {
        List<DVDto> returnValue = new ArrayList<>();

        List<DVEntity> allDV = dvRepo.findAll();
        List<DVEntity> allDVByArticle = new LinkedList<>();

        for(int i=0;i<allDV.size();i++){

            if(allDV.get(i).getArticleId().equals(articleId)){

                allDVByArticle.add(allDV.get(i));
            }
        }
        for (DVEntity dvEntity : allDVByArticle) {
            DVDto dvDto = new DVDto();
            BeanUtils.copyProperties(dvEntity, dvDto);
            returnValue.add(dvDto);
        }
        return returnValue;
    }
}
