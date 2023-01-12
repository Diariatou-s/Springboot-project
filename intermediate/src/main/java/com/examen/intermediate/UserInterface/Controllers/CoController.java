package com.examen.intermediate.UserInterface.Controllers;

import com.examen.intermediate.DataTransfers.Objects.CoDto;
import com.examen.intermediate.Service.CoService;
import com.examen.intermediate.UserInterface.Model.Request.CoRequest;
import com.examen.intermediate.UserInterface.Model.Response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("co")
public class CoController {

    @Autowired
    CoService coService;

    @PostMapping
    public CoRest addComment(@RequestBody CoRequest co) {
        CoRest returnValue = new CoRest();
        CoDto coDto = new CoDto();

        BeanUtils.copyProperties(co, coDto);

        CoDto createdCo = coService.addCo(coDto);
        BeanUtils.copyProperties(createdCo, returnValue);

        return returnValue;
    }

    @GetMapping("/article/{id}")
    public List<CoRest> getAllCoByAr(@PathVariable("id") String articleId) {
        List<CoRest> returnValue = new ArrayList<>();

        List<CoDto> comments = coService.allCoByAr(articleId);

        for (CoDto coDto : comments) {
            CoRest coModel = new CoRest();
            BeanUtils.copyProperties(coDto, coModel);
            returnValue.add(coModel);
        }

        return returnValue;
    }
}
