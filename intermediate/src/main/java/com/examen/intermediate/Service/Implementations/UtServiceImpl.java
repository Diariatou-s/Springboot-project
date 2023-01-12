package com.examen.intermediate.Service.Implementations;

import com.examen.intermediate.DataTransfers.Objects.UtDto;
import com.examen.intermediate.InputOutputs.Entities.UtEntity;
import com.examen.intermediate.DataTransfers.Utils;
import com.examen.intermediate.Service.UtService;
import com.examen.intermediate.InputOutputs.Repositories.UtRepo;
import com.examen.intermediate.UserInterface.Model.Request.UtLoginRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtServiceImpl implements UtService {

    @Autowired
    UtRepo utRepo;

    @Autowired
    Utils utils;

    @Override
    public UtDto loginUt(UtLoginRequest ut) {
        List<UtEntity> allUser = utRepo.findAll();
        UtDto returnValue = new UtDto();
        UtEntity user = new UtEntity();
        for(int i = 0; i<allUser.size(); i++){

            if(ut.getEmail().equals(allUser.get(i).getEmail())){

                if(ut.getMdp().equals(allUser.get(i).getMdp())){

                    user = allUser.get(i);
                }
            }
        }
        BeanUtils.copyProperties(user, returnValue);

        return returnValue;
    }

    @Override
    public UtDto createUt(UtDto ut) {
        if(utRepo.findByEmail(ut.getEmail()) != null) throw new RuntimeException("Record already exist");

        UtEntity utEntity = new UtEntity();
        BeanUtils.copyProperties(ut, utEntity);

        String publicUserId = utils.generateUserId(20);

        utEntity.setUserId(publicUserId);

        UtEntity storedUtDetails = utRepo.save(utEntity);

        UtDto returnValue = new UtDto();
        BeanUtils.copyProperties(storedUtDetails, returnValue);

        return returnValue;
    }

    @Override
    public UtDto getUserByUserId(String userId) {
        UtDto returnValue = new UtDto();

        UtEntity utEntity = utRepo.findByUserId(userId);

        BeanUtils.copyProperties(utEntity, returnValue);

        return returnValue;
    }

    @Override
    public UtDto updateUserById(String userId, UtDto utDto) {
        UtDto returnValue = new UtDto();

        UtEntity utEntity = utRepo.findByUserId(userId);

        utEntity.setPrenom(utDto.getPrenom());
        utEntity.setNom(utDto.getNom());
        utEntity.setBio(utDto.getBio());

        UtEntity updatedUt = utRepo.save(utEntity);
        BeanUtils.copyProperties(updatedUt, returnValue);

        return returnValue;
    }

    @Override
    public List<UtDto> getUsers(int page, int limit) {
        List<UtDto> returnValue = new ArrayList<>();

        if(page>0) page = page-1;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<UtEntity> usersPage = utRepo.findAll(pageableRequest);
        List<UtEntity> users = usersPage.getContent();

        for (UtEntity utEntity : users) {
            UtDto utDto = new UtDto();
            BeanUtils.copyProperties(utEntity, utDto);
            returnValue.add(utDto);
        }

        return returnValue;
    }

}
