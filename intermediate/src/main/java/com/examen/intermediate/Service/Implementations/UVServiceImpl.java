package com.examen.intermediate.Service.Implementations;

import com.examen.intermediate.DataTransfers.Objects.UVDto;
import com.examen.intermediate.InputOutputs.Entities.UVEntity;
import com.examen.intermediate.InputOutputs.Repositories.UVRepo;
import com.examen.intermediate.Service.UVService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class UVServiceImpl implements UVService {

    @Autowired
    UVRepo uvRepo;

    @Override
    public UVDto addUV(UVDto uv) {
        UVEntity uvEntity = new UVEntity();
        BeanUtils.copyProperties(uv, uvEntity);

        UVEntity newUpvote = uvRepo.save(uvEntity);

        UVDto returnValue = new UVDto();
        BeanUtils.copyProperties(newUpvote, returnValue);

        return returnValue;
    }

    @Override
    public List<UVDto> getAllUVByAr(String articleId) {
        List<UVDto> returnValue = new ArrayList<>();

        List<UVEntity> allUV = uvRepo.findAll();
        List<UVEntity> allUVByArticle = new LinkedList<>();

        for(int i=0;i<allUV.size();i++){

            if(allUV.get(i).getArticleId().equals(articleId)){

                allUVByArticle.add(allUV.get(i));
            }
        }
        for (UVEntity uvEntity : allUVByArticle) {
            UVDto uvDto = new UVDto();
            BeanUtils.copyProperties(uvEntity, uvDto);
            returnValue.add(uvDto);
        }
        return returnValue;

    }
}
