package com.examen.intermediate.UserInterface.Controllers;

import com.examen.intermediate.DataTransfers.Objects.UVDto;
import com.examen.intermediate.Service.UVService;
import com.examen.intermediate.UserInterface.Model.Response.UVRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("uv")
public class UVController {

    @Autowired
    UVService uvService;

    @PostMapping
    public UVRest addUpvote(@RequestBody UVRest uv) throws Exception {
        UVRest returnValue = new UVRest();
        UVDto uvDto = new UVDto();

        BeanUtils.copyProperties(uv, uvDto);

        UVDto addedUV = uvService.addUV(uvDto);
        BeanUtils.copyProperties(addedUV, returnValue);

        return returnValue;
    }

    @GetMapping(path="/{id}")
    public List<UVRest> getAllUVByAr(@PathVariable String id) {
        List<UVRest> returnValue = new ArrayList<>();

        List<UVDto> upvotes = uvService.getAllUVByAr(id);

        for (UVDto uvDto : upvotes) {
            UVRest uvModel = new UVRest();
            BeanUtils.copyProperties(uvDto, uvModel);
            returnValue.add(uvModel);
        }

        return returnValue;
    }
}
