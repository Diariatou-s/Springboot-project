package com.examen.intermediate.UserInterface.Controllers;

import com.examen.intermediate.DataTransfers.Objects.UtDto;
import com.examen.intermediate.Service.UtService;
import com.examen.intermediate.UserInterface.Model.Request.UtChangeRequest;
import com.examen.intermediate.UserInterface.Model.Request.UtLoginRequest;
import com.examen.intermediate.UserInterface.Model.Request.UtRequest;
import com.examen.intermediate.UserInterface.Model.Response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("ut")
public class UtController {

    @Autowired
    UtService utService;

    @GetMapping(path="/{id}")
    public UtRest getUser(@PathVariable String id){
        UtRest returnValue = new UtRest();

        UtDto utDto = utService.getUserByUserId(id);

        BeanUtils.copyProperties(utDto, returnValue);

        return returnValue;
    }

    @PostMapping("/login")
    public ResponseEntity<?> logUser(@RequestBody UtLoginRequest ut){
        UtDto user = utService.loginUt(ut);
        if(user == null){
            HashMap<String, Object> valeurToreturn = new HashMap<>();
            valeurToreturn.put("message","Email ou mot de passe incorrect");
            return new ResponseEntity<>(valeurToreturn, HttpStatus.OK);
        }
        UtRest returnValue = new UtRest();
        BeanUtils.copyProperties(user, returnValue);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PostMapping
    public UtRest createUser(@RequestBody UtRequest ut) throws Exception {
        UtRest returnValue = new UtRest();
        UtDto utDto = new UtDto();

        BeanUtils.copyProperties(ut, utDto);

        UtDto createdUt = utService.createUt(utDto);
        BeanUtils.copyProperties(createdUt, returnValue);

        return returnValue;
    }

    @PutMapping("/user/{id}")
    public UtRest updateUser(@PathVariable("id") String id, @RequestBody UtChangeRequest ut){
        UtRest returnValue = new UtRest();
        UtDto utDto = new UtDto();

        BeanUtils.copyProperties(ut, utDto);

        UtDto updatedUt = utService.updateUserById(id, utDto);
        BeanUtils.copyProperties(updatedUt, returnValue);

        return returnValue;
    }

    @GetMapping
    public List<UtRest> getUsers(@RequestParam(value="page", defaultValue="1")int page, @RequestParam(value="limit", defaultValue = "5")int limit) {
        List<UtRest> returnValue = new ArrayList<>();

        List<UtDto> users = utService.getUsers(page, limit);

        for (UtDto utDto : users) {
            UtRest utModel = new UtRest();
            BeanUtils.copyProperties(utDto, utModel);
            returnValue.add(utModel);
        }

        return returnValue;
    }
}
