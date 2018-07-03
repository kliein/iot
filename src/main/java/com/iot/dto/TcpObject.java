package com.iot.dto;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;




@Data
public class TcpObject {


    private String userSerialNumber;
    private int slaveNumber;
    private ChannelHandlerContext ctx;

}
