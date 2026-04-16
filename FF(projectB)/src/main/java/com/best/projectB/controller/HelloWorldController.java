package com.best.projectB.controller;

import com.best.projectB.dto.FPVDto;
import com.best.projectB.dto.FPVEditDto;
import com.best.projectB.entity.FPV;
import com.best.projectB.service.FPVService;
import com.best.projectB.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloWorldController {


    @Autowired
    private FPVService service;


    @GetMapping("hello")
    public Map<String,String> getHello(){
        Map<String,String> map = new HashMap<>();
        map.put("key","hello world");
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
    public JsonResponse createFPV(@RequestBody FPVDto dto){
        return new JsonResponse().OK(() -> service.createFPV(dto));

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
