package com.best.projectB.dao;

import com.best.projectB.entity.FPV;
import com.best.projectB.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {


    @Query(value = "select * from user_info where username = ?",nativeQuery = true)
    UserInfo getUserByName(String username);
}
