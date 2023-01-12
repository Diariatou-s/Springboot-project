package com.examen.intermediate.UserInterface.Controllers;

import com.examen.intermediate.DataTransfers.Objects.DVDto;
import com.examen.intermediate.Service.DVService;
import com.examen.intermediate.UserInterface.Model.Response.DVRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("dv")
public class DVController {

    @Autowired
    DVService dvService;

    @PostMapping
    public DVRest addDownvote(@RequestBody DVRest dv) throws Exception {
        DVRest returnValue = new DVRest();
        DVDto dvDto = new DVDto();

        BeanUtils.copyProperties(dv, dvDto);

        DVDto addedDV = dvService.addDV(dvDto);
        BeanUtils.copyProperties(addedDV, returnValue);

        return returnValue;
    }

    @GetMapping(path="/{id}")
    public List<DVRest> getAllDVByAr(@PathVariable String id) {
        List<DVRest> returnValue = new ArrayList<>();

        List<DVDto> downvotes = dvService.getAllDVByAr(id);

        for (DVDto dvDto : downvotes) {
            DVRest dvModel = new DVRest();
            BeanUtils.copyProperties(dvDto, dvModel);
            returnValue.add(dvModel);
        }

        return returnValue;
    }
}
