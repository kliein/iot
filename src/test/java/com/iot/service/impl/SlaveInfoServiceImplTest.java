package com.iot.service.impl;

import com.iot.entity.SlaveInfo;
import com.iot.service.Impl.SlaveInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SlaveInfoServiceImplTest {

    @Autowired
    private SlaveInfoServiceImpl slaveInfoService;

    @Test
    public void save() {
        SlaveInfo slaveInfo=new SlaveInfo();
        slaveInfo.setSlaveRemark("world");
        slaveInfo.setSlaveNumber(5);
        slaveInfo.setSlaveIp("124.265.23.9");
        slaveInfo.setUserSerialNumber("124577");
        slaveInfoService.save(slaveInfo);
    }

    @Test
    public void findByUserSerialNumberIn() {
        SlaveInfo slaveInfo=slaveInfoService.findByUserSerialNumberIn("124577");
        log.info("【查询结果】：{}",slaveInfo.toString());
    }

    @Test
    public void findAllByUserSerialNumberInTest(){
        PageRequest request=new PageRequest(0,2);
        Page<SlaveInfo> result=slaveInfoService.findAllByUserSerialNumberInOrderByCreateTimeDesc(request,"456123");

        log.info("【查询结果】：{}",result.getTotalElements());
    }
}