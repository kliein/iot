package com.iot.service;

import com.iot.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void save() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("user");
        userInfo.setUserPassWord("111111");
        UserInfo result= userInfoService.save(userInfo);

        log.info("【查询结果】：{}",result.toString());
    }
}