package com.iot.Respository;

import com.iot.entity.TestData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import sun.dc.pr.PRError;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestDataInfoRespositoryTest {

    @Autowired
    private TestDataInfoRespository testDataInfoRespository;

    @Test
    public void findAllTest(){
        PageRequest request=new PageRequest(0,2);
        Page<TestData> testDataPage=testDataInfoRespository.findAll(request);
        log.info("【查询结果】：{}",testDataPage.getTotalElements());
    }


}