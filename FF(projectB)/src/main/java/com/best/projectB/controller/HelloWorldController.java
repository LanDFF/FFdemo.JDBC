package com.best.projectB.controller;

import com.best.projectB.dao.FPVRepository;
import com.best.projectB.dto.FPVDto;
import com.best.projectB.dto.FPVEditDto;
import com.best.projectB.entity.FPV;
import com.best.projectB.service.FPVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class HelloWorldController {


    @Autowired
    private FPVService service;


    @GetMapping("hello")
    public Map<String,String> getHello(){
        Map<String,String> map = new HashMap<>();
        map.put("data","hello world");
        return map;
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


    @GetMapping("fpv/one")
    @CrossOrigin(origins = "*")
    public FPV findOneById(@RequestParam Long id) {
        return service.findOneById(id);
    }



    @GetMapping("fpv/all")
    public List<FPV> getAll(){
        return service.selectAll();
    }

    @GetMapping("fpv/one/id")
    public FPV getAll(@RequestParam Long id){
        return service.selectOneNyId(id);
    }

    @PutMapping("fpv/edit/id")
    public String edit(@RequestBody Long id){
        return null;
    }




}
