package com.iot.handler;

import com.iot.IotApplication;
import com.iot.constant.CommunicationType;
import com.iot.dto.TestInfoDTO;
import com.iot.socket.UDPServer;
import com.iot.socket.UdpEntity;
import com.iot.util.ByteUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UDPServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, DatagramPacket datagramPacket) throws Exception {

        String path=datagramPacket.sender().getHostString() +":"+ datagramPacket.sender().getPort();
        ByteBuf buf = datagramPacket.copy().content();
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        int[] res=ByteUtil.convert(req);
        TestInfoDTO testDataInfoService1=IotApplication.getBean(TestInfoDTO.class);//从spring容器取
        testDataInfoService1.insertTestData(res,path, CommunicationType.Udp);
        IotApplication.destroy(TestInfoDTO.class.getName());
        DatagramPacket dp = new DatagramPacket(Unpooled.copiedBuffer(req), datagramPacket.sender());
        UdpEntity udpEntity=new UdpEntity(ctx,datagramPacket);
        UDPServer.ctxUdpList.add(udpEntity);
        ctx.channel().writeAndFlush(dp);
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
    }
}
