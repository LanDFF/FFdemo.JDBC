package com.best.projectB.controller;


import com.best.projectB.dto.User;
import com.best.projectB.dto.UserDto;
import com.best.projectB.dto.UserInfo;
import com.best.projectB.dto.UserInfoDto;
import com.best.projectB.service.UserInfoService;
import com.best.projectB.utils.JsonResponse;
import com.best.projectB.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {


    @Autowired
    private UserInfoService userInfoService;




    @PostMapping("v1/login")
    public Result<UserDto> login(@RequestBody UserInfoDto dto){
        UserDto userDto = userInfoService.login(dto.getUsername(),dto.getPassword());
        return new  Result<>(userDto,Result.SUCCESS);
    }




}
