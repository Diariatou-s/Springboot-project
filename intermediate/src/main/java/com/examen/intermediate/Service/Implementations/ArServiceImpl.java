package com.examen.intermediate.Service.Implementations;

import com.examen.intermediate.DataTransfers.Objects.ArDto;
import com.examen.intermediate.DataTransfers.Utils;
import com.examen.intermediate.InputOutputs.Entities.ArEntity;
import com.examen.intermediate.InputOutputs.Repositories.ArRepo;
import com.examen.intermediate.Service.ArService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ArServiceImpl implements ArService {

    @Autowired
    ArRepo arRepo;

    @Autowired
    Utils utils;

    @Override
    public ArDto addAr(ArDto ar) {
        ArDto returnValue = new ArDto();

        ArEntity arEntity = new ArEntity();
        BeanUtils.copyProperties(ar, arEntity);

        String articleId = utils.generateUserId(20);
        Date dateCourante = new Date();

        arEntity.setArticleId(articleId);
        arEntity.setDate_creation(dateCourante);
        arEntity.setNmb_comm(0);
        arEntity.setNmb_fav(0);
        arEntity.setNmb_upvotes(0);
        arEntity.setNmb_downvotes(0);

        ArEntity newArticle = arRepo.save(arEntity);

        BeanUtils.copyProperties(newArticle, returnValue);

        return returnValue;
    }

    @Override
    public List<ArDto> getAllArByAuthor(String auteurId) {
        List<ArDto> returnValue = new ArrayList<>();

        List<ArEntity> allAr = arRepo.findAll();
        List<ArEntity> allArByAuthor = new LinkedList<>();

        for(int i=0;i<allAr.size();i++){

            if(allAr.get(i).getAuteurId().equals(auteurId)){

                allArByAuthor.add(allAr.get(i));
            }
        }
        for (ArEntity arEntity : allArByAuthor) {
            ArDto arDto = new ArDto();
            BeanUtils.copyProperties(arEntity, arDto);
            returnValue.add(arDto);
        }

        return returnValue;
    }

    @Override
    public List<ArDto> getAllArByTopic(Long categorieId) {
        List<ArDto> returnValue = new ArrayList<>();

        List<ArEntity> allAr = arRepo.findAll();
        List<ArEntity> allArByAuthor = new LinkedList<>();

        for(int i=0;i<allAr.size();i++){

            if(allAr.get(i).getCategorieId() == categorieId){

                allArByAuthor.add(allAr.get(i));
            }
        }
        for (ArEntity arEntity : allArByAuthor) {
            ArDto arDto = new ArDto();
            BeanUtils.copyProperties(arEntity, arDto);
            returnValue.add(arDto);
        }

        return returnValue;
    }

    @Override
    public List<ArDto> getAllAr(int page, int limit) {
        List<ArDto> returnValue = new ArrayList<>();

        if(page>0) page = page-1;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<ArEntity> articlesPage = arRepo.findAll(pageableRequest);
        List<ArEntity> articles = articlesPage.getContent();

        for (ArEntity arEntity : articles) {
            ArDto arDto = new ArDto();
            BeanUtils.copyProperties(arEntity, arDto);
            returnValue.add(arDto);
        }

        return returnValue;
    }

    @Override
    public ArDto updateAr(ArDto ar) {
        ArDto returnValue = new ArDto();

        ArEntity arEntity = new ArEntity();
        BeanUtils.copyProperties(ar, arEntity);

        ArEntity updatedAr = arRepo.save(arEntity);
        BeanUtils.copyProperties(updatedAr, returnValue);

        return returnValue;
    }

    @Override
    public ArDto getArById(String id) {
        ArDto returnValue = new ArDto();

        ArEntity arEntity = arRepo.findByArticleId(id);
        BeanUtils.copyProperties(arEntity, returnValue);

        return returnValue;
    }

    @Override
    public void deleteArById(String id) {

        ArEntity arEntity = arRepo.findByArticleId(id);

        arRepo.delete(arEntity);
    }
}
