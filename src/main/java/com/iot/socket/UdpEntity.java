package com.iot.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import lombok.Data;

@Data
public class UdpEntity {

    private DatagramPacket datagramPacket;
    private ChannelHandlerContext ctx;

    public UdpEntity(ChannelHandlerContext ctx,DatagramPacket datagramPacket) {
        this.datagramPacket = datagramPacket;
        this.ctx = ctx;
    }
}
