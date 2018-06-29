package com.iot.socket;

import com.iot.handler.UDPServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class UDPServer {




    private final int port;


    public static List<UdpEntity> ctxUdpList=new ArrayList<>();


    public UDPServer(int port){
        this.port=port;
    }
    public void start() throws InterruptedException {

        EventLoopGroup group=new NioEventLoopGroup();
        log.info("【UDP服务启动成功】端口:{}",this.port);
        try {
            Bootstrap b=new Bootstrap();
            b.group(group)

                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST,true)
                    .handler(new UDPServerHandler());

            b.bind(port).sync().channel().closeFuture().await();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            group.shutdownGracefully();
        }
    }

}


