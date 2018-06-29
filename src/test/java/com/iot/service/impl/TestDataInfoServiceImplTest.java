package com.iot.service.impl;

import com.iot.entity.TestData;
import com.iot.entity.TestInfo;
import com.iot.service.Impl.TestDataInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDataInfoServiceImplTest {

    @Autowired
    private TestDataInfoServiceImpl testDataInfoService;

    @Test
    public void findAllByUserSerialNumberAndSlaveNumberOrderByCreateTimeDesc() {
        PageRequest request=new PageRequest(0,2);
        Page<TestData> testDataPage=testDataInfoService.findAllByUserSerialNumberAndSlaveNumberOrderByCreateTimeDesc(request
        ,"444444",5);
        log.info("【查询结果】：{}",testDataPage.getTotalElements());
    }

    @Test
    public void saveTest(){
        TestData testData=new TestData();
        testData.setUserSerialNumber("123456");
        testData.setSlaveNumber(5);
        testData.setTestDataInfo("cccccc");
        testData.setSlaveIp("112.23.56.489");
        testDataInfoService.save(testData);

    }
}