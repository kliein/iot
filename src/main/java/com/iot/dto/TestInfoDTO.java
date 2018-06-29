package com.iot.dto;


import com.iot.ProtocolAnalysis.Analysis;
import com.iot.entity.TestData;
import com.iot.service.TestDataInfoService;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;


@Slf4j
@Component
public class TestInfoDTO  {

    @Autowired
    private TestDataInfoService testDataInfoService;

    public TestInfoDTO() {

        log.info("**********");
    }


    public void insertTestData(int[] data, String ctx,String type){

        Analysis analysis=new Analysis();
        String testInfo= analysis.analysisData(data);
        String serialNumber=analysis.analysisSerialNumber(data);
        int slaveNumber=analysis.analysisSlaveNumber(data);

        TestData testData=new TestData();
        testData.setType(type);
        testData.setSlaveIp(ctx);
        testData.setTestDataInfo(testInfo);
        testData.setSlaveNumber(slaveNumber);
        testData.setUserSerialNumber(serialNumber);
        //log.info("【数据】：{}",testData.toString());
        testDataInfoService.save(testData);
    }

}
