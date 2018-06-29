package com.iot.handler;

import com.iot.IotApplication;
import com.iot.constant.CommunicationType;
import com.iot.dto.TestInfoDTO;
import com.iot.socket.TCPServer;
import com.iot.util.ByteUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;


import java.net.InetSocketAddress;


@Slf4j
public class TCPServerHandler extends SimpleChannelInboundHandler<byte[]>{

    // 55 AA    用户序列号   设备ID       数据长度  数据      校验
    // 55 AA    55 55 55    55 55 55     55 55   11 11      21
    // 2字节      3字节      3字节         2字节    2字节    和校验（从序列号开始到数据位最后一位）
    //55 aa 5a 94 09 00 00 05 00 02 11 11 1f

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, byte[] msg) throws Exception {
        String socket = ctx.channel().remoteAddress().toString();
        socket=socket.substring(1);
       // String clientIP = socket.getAddress().getHostAddress();
        int[] res=ByteUtil.convert(msg);
        TestInfoDTO testDataInfoService1=IotApplication.getBean(TestInfoDTO.class);//从spring容器取
        testDataInfoService1.insertTestData(res,socket,CommunicationType.Tcp);
        IotApplication.destroy(TestInfoDTO.class.getName());
        ctx.channel().writeAndFlush(msg);
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("【客户端断开连接】");
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       cause.printStackTrace();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event=(IdleStateEvent)evt;
            if(event.state()==IdleState.ALL_IDLE){
                ChannelFuture channelFuture = ctx.writeAndFlush("time out you will be closed");
                channelFuture.addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        ctx.channel().close();
                    }
                });
            }
        }
        super.userEventTriggered(ctx, evt);
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress socket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIP = socket.getAddress().getHostAddress();
        TCPServer.ctxTcpList.add(ctx);
        log.info("【有新的客户端连接】IP:{}",clientIP);
        super.channelActive(ctx);
    }
}
