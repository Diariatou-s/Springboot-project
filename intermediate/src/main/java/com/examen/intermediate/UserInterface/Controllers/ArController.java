package com.examen.intermediate.UserInterface.Controllers;

import com.examen.intermediate.DataTransfers.Objects.ArDto;
import com.examen.intermediate.Service.ArService;
import com.examen.intermediate.UserInterface.Model.Request.ArRequest;
import com.examen.intermediate.UserInterface.Model.Response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ar")
public class ArController {

    @Autowired
    ArService arService;

    @PostMapping
    public ArRest addAr(@RequestBody ArRequest ar) throws Exception {
        ArRest returnValue = new ArRest();
        ArDto arDto = new ArDto();

        BeanUtils.copyProperties(ar, arDto);

        ArDto createdAr = arService.addAr(arDto);
        BeanUtils.copyProperties(createdAr, returnValue);

        return returnValue;
    }

    @GetMapping("/author/{id}")
    public List<ArRest> getArByAuthor(@PathVariable("id") String auteurId) {
        List<ArRest> returnValue = new ArrayList<>();

        List<ArDto> articles = arService.getAllArByAuthor(auteurId);

        for (ArDto arDto : articles) {
            ArRest arModel = new ArRest();
            BeanUtils.copyProperties(arDto, arModel);
            returnValue.add(arModel);
        }

        return returnValue;
    }

    @GetMapping("/topic/{id}")
    public List<ArRest> getArByTopic(@PathVariable("id") Long categorieId) {
        List<ArRest> returnValue = new ArrayList<>();

        List<ArDto> articles = arService.getAllArByTopic(categorieId);

        for (ArDto arDto : articles) {
            ArRest arModel = new ArRest();
            BeanUtils.copyProperties(arDto, arModel);
            returnValue.add(arModel);
        }

        return returnValue;
    }

    @GetMapping
    public List<ArRest> getAllAr(@RequestParam(value="page", defaultValue="1")int page, @RequestParam(value="limit", defaultValue = "15")int limit) {
        List<ArRest> returnValue = new ArrayList<>();

        List<ArDto> articles = arService.getAllAr(page, limit);

        for (ArDto arDto : articles) {
            ArRest arModel = new ArRest();
            BeanUtils.copyProperties(arDto, arModel);
            returnValue.add(arModel);
        }

        return returnValue;
    }

    @PutMapping("/addUpvote/{id}")
    public ArRest addUpvote(@PathVariable("id") String id){
        ArRest returnValue = new ArRest();

        ArDto arDto =arService.getArById(id);
        int newNmbUpvotes = arDto.getNmb_upvotes() + 1;
        arDto.setNmb_upvotes(newNmbUpvotes);
        ArDto updatedAr = arService.updateAr(arDto);

        BeanUtils.copyProperties(updatedAr,returnValue);

        return returnValue;
    }

    @PutMapping("/addDownvote/{id}")
    public ArRest addDownvote(@PathVariable("id") String id){
        ArRest returnValue = new ArRest();

        ArDto arDto =arService.getArById(id);
        int newNmbDownvotes = arDto.getNmb_downvotes() + 1;
        arDto.setNmb_downvotes(newNmbDownvotes);
        ArDto updatedAr = arService.updateAr(arDto);

        BeanUtils.copyProperties(updatedAr,returnValue);

        return returnValue;
    }

    @PutMapping("/addComment/{id}")
    public ArRest addComment(@PathVariable("id") String id){
        ArRest returnValue = new ArRest();

        ArDto arDto =arService.getArById(id);
        int newNmbComm = arDto.getNmb_comm() + 1;
        arDto.setNmb_comm(newNmbComm);
        ArDto updatedAr = arService.updateAr(arDto);

        BeanUtils.copyProperties(updatedAr,returnValue);

        return returnValue;
    }

    @PutMapping("/addFavorite/{id}")
    public ArRest addFavorite(@PathVariable("id") String id){
        ArRest returnValue = new ArRest();

        ArDto arDto =arService.getArById(id);
        int newNmbFav = arDto.getNmb_fav() + 1;
        arDto.setNmb_fav(newNmbFav);
        ArDto updatedAr = arService.updateAr(arDto);

        BeanUtils.copyProperties(updatedAr,returnValue);

        return returnValue;
    }

    @GetMapping("/id/{id}")
    public ArRest getArById(@PathVariable("id") String id){
        ArRest returnValue = new ArRest();

        ArDto ar = arService.getArById(id);
        BeanUtils.copyProperties(ar, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatus deleteAr(@PathVariable String id){
        OperationStatus returnValue = new OperationStatus();

        returnValue.setOperationName(OperationName.DELETE.name());
        arService.deleteArById(id);

        returnValue.setOperationResult(OperationResult.SUCCESS.name());

        return returnValue;
    }
}
