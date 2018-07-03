package com.iot.constant;


import com.iot.dto.TcpObject;
import com.iot.dto.UdpObject;
import com.iot.socket.UdpEntity;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.CopyOnWriteArrayList;

public class NetObject {

    public static CopyOnWriteArrayList<TcpObject> tcpObjectCopyOnWriteArrayList=new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<UdpObject> udpObjectCopyOnWriteArrayList=new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<ChannelHandlerContext> tcpCtxList=new CopyOnWriteArrayList<>();//tcp客户端存储
    public static CopyOnWriteArrayList<UdpEntity> udpCtxList=new CopyOnWriteArrayList<>();//udp客户端存储
    public static Channel udpChannel;
}
