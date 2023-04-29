package com.examen.intermediate.Service.Implementations;

import com.examen.intermediate.DataTransfers.Objects.CoDto;
import com.examen.intermediate.InputOutputs.Entities.CoEntity;
import com.examen.intermediate.InputOutputs.Repositories.CoRepo;
import com.examen.intermediate.Service.CoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CoServiceImpl implements CoService {

    @Autowired
    CoRepo coRepo;


    @Override
    public CoDto addCo(CoDto co) {
        CoEntity coEntity = new CoEntity();
        BeanUtils.copyProperties(co, coEntity);

        CoEntity newComment = coRepo.save(coEntity);

        CoDto returnValue = new CoDto();
        BeanUtils.copyProperties(newComment, returnValue);

        return returnValue;
    }

    @Override
    public List<CoDto> allCoByAr(String articleId) {
        List<CoDto> returnValue = new ArrayList<>();

        List<CoEntity> allCo = coRepo.findAll();
        List<CoEntity> allCoByArticle = new LinkedList<>();

        for(int i=0;i<allCo.size();i++){

            if(allCo.get(i).getArticleId().equals(articleId)){

                allCoByArticle.add(allCo.get(i));
            }
        }
        for (CoEntity coEntity : allCoByArticle) {
            CoDto coDto = new CoDto();
            BeanUtils.copyProperties(coEntity, coDto);
            returnValue.add(coDto);
        }
        return returnValue;
    }
}
