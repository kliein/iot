package com.iot.Respository;

import com.iot.entity.SlaveInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.ref.PhantomReference;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SlaveInfoRespositoryTest {

    @Autowired
    private SlaveInfoRespository slaveInfoRespository;

    @Test
    public void saveTest(){
        SlaveInfo slaveInfo=new SlaveInfo();
        slaveInfo.setUserSerialNumber("456123");
        slaveInfo.setSlaveIp("118.26.145.25");
        slaveInfo.setSlaveNumber(2);
        slaveInfo.setSlaveRemark("hello");
        slaveInfoRespository.save(slaveInfo);

    }


}