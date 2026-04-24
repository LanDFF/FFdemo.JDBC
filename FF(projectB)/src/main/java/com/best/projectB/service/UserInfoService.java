package com.best.projectB.service;


import com.best.projectB.dao.UserInfoRepository;
import com.best.projectB.dto.UserDto;
import com.best.projectB.dto.UserInfoDto;
import com.best.projectB.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserDto login(String username,String password){

        UserInfo info = userInfoRepository.getUserByName(username);

        if(info == null) {
            throw new RuntimeException("用户不存在!");
        }

        if(!info.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        UserDto dto = new UserDto();

        dto.setId(info.getId());
        dto.setUsername(info.getUsername());




        return dto;

    }

//    UserInfo userInfo = userInfoRepository.getUserByName(username);
//
//        if(userInfo == null) {
//        throw new RuntimeException("用户不存在!");
//    }
//
//        if(password.equals(userInfo.getPassword())){
//        UserDto dto = new UserDto();
//        dto.setId(userInfo.getId());
//        dto.setUsername(userInfo.getUsername());
//
//        return dto;
//    }
//        throw new RuntimeException("密码错误");





}
