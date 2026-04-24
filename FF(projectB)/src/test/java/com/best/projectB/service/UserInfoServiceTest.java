package com.best.projectB.service;

import com.best.projectB.dao.UserInfoRepository;
import com.best.projectB.dto.UserDto;
import com.best.projectB.entity.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserInfoService userInfoService;


//    @Test
//    public void testUserInfo() {
//
//        UserInfo userInfo = userInfoRepository.getUserByName("admin");
//
//        Assertions.assertEquals(1,userInfo.getId());
//
//        userInfo = userInfoRepository.getUserByName("test");
//
//        Assertions.assertEquals(2,userInfo.getId());
//
//        Assertions.assertEquals("test",userInfo.getPassword());
//
//    }

    @Test
    public void testUserInfoService(){

        UserDto dto = userInfoService.login("admin","admin");

        Assertions.assertEquals(1,dto.getId());
        Assertions.assertEquals("admin",dto.getUsername());



    }

    @Test
    public void exceptionUserInfoService() {

        try {
            userInfoService.login("a", "a");
        } catch (Exception ex) {
            Assertions.assertEquals("用户不存在!", ex.getMessage());
        }
    }

    @Test
    public void passwordError(){


        try {
            userInfoService.login("admin","a");
        }catch (Exception ex){
            Assertions.assertEquals("密码错误",ex.getMessage());
        }



    }

}
