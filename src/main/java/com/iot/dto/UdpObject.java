package com.iot.dto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import lombok.Data;

@Data
public class UdpObject {

    private String userSerialNumber;
    private int slaveNumber;
    private DatagramPacket datagramPacket;
    private ChannelHandlerContext ctx;
}
