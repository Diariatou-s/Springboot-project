package com.examen.intermediate.UserInterface.Controllers;

import com.examen.intermediate.DataTransfers.Objects.FaDto;
import com.examen.intermediate.Service.FaService;
import com.examen.intermediate.UserInterface.Model.Response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("fa")
public class FaController {

    @Autowired
    FaService faService;

    @PostMapping
    public FaRest addFavorite(@RequestBody FaRest fa) throws Exception {
        FaRest returnValue = new FaRest();
        FaDto faDto = new FaDto();

        BeanUtils.copyProperties(fa, faDto);

        FaDto addedFa = faService.addFa(faDto);
        BeanUtils.copyProperties(addedFa, returnValue);

        return returnValue;
    }

    @GetMapping("/ut/{id}")
    public List<FaRest> getAllFaByUt(@PathVariable String id) {
        List<FaRest> returnValue = new ArrayList<>();

        List<FaDto> favorites = faService.getAllFaByUt(id);

        for (FaDto faDto : favorites) {
            FaRest faModel = new FaRest();
            BeanUtils.copyProperties(faDto, faModel);
            returnValue.add(faModel);
        }

        return returnValue;
    }
}
