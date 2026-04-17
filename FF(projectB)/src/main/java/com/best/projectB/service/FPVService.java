package com.best.projectB.service;


import com.best.projectB.dao.FPVRepository;
import com.best.projectB.dto.FPVDto;
import com.best.projectB.dto.FPVEditDto;
import com.best.projectB.entity.FPV;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FPVService {


    @Autowired
    FPVRepository fpvRepository;


    public List<FPVEditDto> getFPVs(){
        List<FPV> fpv = fpvRepository.findAll();

        return getAll(fpv);

    }

    public List<FPVEditDto> getAll(List<FPV> fpv){

        List<FPVEditDto> dtos = new ArrayList<>();
        for (int i = 0;i < fpv.size(); i++){
            FPVEditDto dto = new FPVEditDto();

            dto.setId(fpv.get(i).getId());
            dto.setName(fpv.get(i).getName());

        }


        
        return fpv.stream().map(value -> {
                FPVEditDto dto = new FPVEditDto();
                dto.setFc(value.getFc());
                dto.setId(value.getId());
                dto.setName(value.getName());
                return dto;
        }).collect(Collectors.toList());

    }


    public FPV getFPVById(Long id){
        FPV fpv;
        try {
            fpv = fpvRepository.findById(id).orElseThrow();
        } catch (Exception ex){

            throw new RuntimeException("没有数据");

        }
        return fpv;

    }

    public String createFPV(FPVDto dto){
        FPV fpv = new FPV();

        fpv.setName(dto.getName());
        fpv.setFc(dto.getFc());
        fpv.setExisted("0");
        fpvRepository.save(fpv);

        return "成功!";
    }

    public String updateFPV(FPVEditDto dto){

        FPV fpv = fpvRepository.findById(dto.getId()).orElse(new FPV());
        if(fpv.getId() == null){
            throw new RuntimeException("无法更新！");
        }
        fpv.setFc(dto.getFc());
        fpv.setName(dto.getName());
        fpvRepository.save(fpv);

        return "成功";


    }

    public FPV findOneById(Long id){
        FPV fpv = findOneById(id);

        if (fpv == null) {
            throw new RuntimeException("id" + id + "数据不存在!");

        }
        return fpv;
    }

    public List<FPV> selectAll(){
        return fpvRepository.selectAll();
    }

    public FPV selectOneNyId(Long id){
        return fpvRepository.selectExistedById(id);
    }

    public int updateNameById(FPV fpv){
        Long id = fpv.getId();
        String name = fpv.getName();
        FPV fpv1 = fpvRepository.findById(id).orElse(null);

        if (fpv1 == null) {
            throw new RuntimeException("数据不存在!");
        }

        return fpvRepository.updateNameById(name,id);
    }


}
