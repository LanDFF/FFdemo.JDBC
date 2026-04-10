package com.best.projectB.controller;

import com.best.projectB.dao.FPVRepository;
import com.best.projectB.dto.FPVDto;
import com.best.projectB.dto.FPVEditDto;
import com.best.projectB.entity.FPV;
import com.best.projectB.service.FPVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class HelloWorldController {


    @Autowired
    private FPVService service;


    @GetMapping("hello")
    public String getHello(){
        return "hello world!";
    }


    @GetMapping("fpvs")
    public List<FPVEditDto> getFPVs(){

        return service.getFPVs();

    }


    @GetMapping("fpv/id")
    public FPV getFPVById(@RequestParam Long id){
        return service.getFPVById(id);

    }

    @PostMapping("fpv/create")
    public String createFPV(@RequestBody FPVDto dto){
        return service.creatFPV(dto);

    }


    @PutMapping("fpv/edit")
    public String updateFPVById(@RequestBody FPVEditDto dto){
        return service.updateFPV(dto);
    }




}
