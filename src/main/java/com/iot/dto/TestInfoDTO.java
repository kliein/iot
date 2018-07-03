package com.iot.dto;


import com.iot.ProtocolAnalysis.Analysis;
import com.iot.constant.NetObject;
import com.iot.entity.TestData;
import com.iot.service.TestDataInfoService;
import com.iot.socket.TCPServer;
import com.iot.socket.UdpEntity;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
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

/**
 *@Author:
 *@Description:
 *@Date:15:52 2018/7/2
 */
    public void insertTestData(int[] data, String ipAddress, String type, ChannelHandlerContext ctx, DatagramPacket datagramPacket){

        Analysis analysis=new Analysis();
        String testInfo= analysis.analysisData(data);
        String serialNumber=analysis.analysisSerialNumber(data);
        boolean isConnect=analysis.isConnect(data);
        int slaveNumber=analysis.analysisSlaveNumber(data);

        TestData testData=new TestData();
        testData.setType(type);
        testData.setSlaveIp(ipAddress);
        testData.setTestDataInfo(testInfo);
        testData.setSlaveNumber(slaveNumber);
        testData.setUserSerialNumber(serialNumber);
//        if(isConnect){
//            if(type.equals("TCP")){
//                TcpObject tcpObject=new TcpObject();
//                tcpObject.setCtx(ctx);
//                tcpObject.setSlaveNumber(slaveNumber);
//                tcpObject.setUserSerialNumber(serialNumber);
//                NetObject.tcpObjectCopyOnWriteArrayList.add(tcpObject);
//            }
//            else {
//                UdpObject udpObject=new UdpObject();
//                udpObject.setCtx(ctx);
//                udpObject.setSlaveNumber(slaveNumber);
//                udpObject.setUserSerialNumber(serialNumber);
//                udpObject.setDatagramPacket(datagramPacket);
//                NetObject.udpObjectCopyOnWriteArrayList.add(udpObject);
//            }
//        }
        testDataInfoService.save(testData);
    }

}
