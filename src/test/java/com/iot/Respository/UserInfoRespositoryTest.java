package com.iot.Respository;

import com.iot.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;



@SpringBootTest
@RunWith(SpringRunner.class)

@Slf4j
public class UserInfoRespositoryTest {

    @Autowired
    private UserInfoRespository userInfoRespository;

    @Test
    public void findOneTest(){
        UserInfo userInfo=userInfoRespository.findOne(1);
        log.info("【查询结果】{}",userInfo.toString());
    }

}