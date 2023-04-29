package com.examen.intermediate.UserInterface.Controllers;

import com.examen.intermediate.DataTransfers.Objects.AbDto;
import com.examen.intermediate.Service.AbService;
import com.examen.intermediate.UserInterface.Model.Response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ab")
public class AbController {

    @Autowired
    AbService abService;

    @PostMapping
    public AbRest addAb(@RequestBody AbRest ab){
        AbRest returnValue = new AbRest();

        AbDto abDto = new AbDto();
        BeanUtils.copyProperties(ab, abDto);

        AbDto newAb = abService.addAb(abDto);
        BeanUtils.copyProperties(newAb, returnValue);

        return returnValue;
    }

    @GetMapping("/followings/{id}")
    public List<AbRest> getAllFollowingsByUt(@PathVariable("id") String id){
        List<AbRest> returnValue = new ArrayList<>();

        List<AbDto> followings = abService.getAllFollowingsByUt(id);

        for (AbDto abDto : followings) {
            AbRest abModel = new AbRest();
            BeanUtils.copyProperties(abDto, abModel);
            returnValue.add(abModel);
        }

        return returnValue;
    }

    @GetMapping("/followers/{id}")
    public List<AbRest> getAllFollowersByUt(@PathVariable("id") String id){
        List<AbRest> returnValue = new ArrayList<>();

        List<AbDto> followers = abService.getAllFollowersByUt(id);

        for (AbDto abDto : followers) {
            AbRest abModel = new AbRest();
            BeanUtils.copyProperties(abDto, abModel);
            returnValue.add(abModel);
        }

        return returnValue;
    }
}
