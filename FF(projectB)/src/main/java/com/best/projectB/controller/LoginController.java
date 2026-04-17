package com.best.projectB.controller;


import com.best.projectB.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("login")
    public Map<String,String> login(@RequestBody User user) {

        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")){
            return Map.of("token","success");
        }
        return Map.of("token","error");
    }

    @GetMapping("user/info")
    public UserInfo getInfo(@RequestParam Long id) {
        if (id == 1L) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(1L);
            userInfo.setName("FF");
            userInfo.setAge(18);
            userInfo.setNickName("FFsama");
            userInfo.setAddress("锋锋sama");
            return userInfo;
        }else
            return new UserInfo();
    }




}
