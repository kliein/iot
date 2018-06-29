package com.iot.socket;

import com.iot.handler.TCPServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TCPServer {


    private final int port;

    public static List<ChannelHandlerContext> ctxTcpList=new ArrayList<>();

    public TCPServer(int port){

        this.port=port;
    }

    public void start() throws InterruptedException {
        ServerBootstrap b = new ServerBootstrap();// 引导辅助程序//服务类
        EventLoopGroup boss = new NioEventLoopGroup();// 通过nio方式来接收连接和处理连接
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            b.group(boss,worker);
            b.channel(NioServerSocketChannel.class);// 设置socket工厂
            b.childOption(ChannelOption.TCP_NODELAY,true);
            b.localAddress(new InetSocketAddress(port));// 设置监听端口
            b.childHandler(new ChannelInitializer<SocketChannel>() {//有连接到达时会创建一个channel，设置管道工厂

                protected void initChannel(SocketChannel ch) throws Exception {
                    // pipeline管理channel中的Handler，在channel队列中添加一个handler来处理业务

                    //重要，该类实现心跳检测,第一个参数：读超时时间。第二个参数：写超时时间。第三个参数：读写超时时间。
                    //心跳作用：清除闲置的会话，释放资源。
                    //对客户端来说，心跳可实现断线重新连接。
                    ch.pipeline().addLast(new IdleStateHandler(10,10,20));
                    //过滤编码
                    ch.pipeline().addLast(new ByteArrayDecoder());
                    ch.pipeline().addLast(new ByteArrayEncoder());
                    ch.pipeline().addLast("myHandler", new TCPServerHandler());
                }
            });
            ChannelFuture f = b.bind().sync();// 配置完成，开始绑定server，通过调用sync同步方法阻塞直到绑定成功
            log.info("【TCP服务启动成功】端口:{}",port);
            f.channel().closeFuture().sync();// 应用程序会一直等待，直到channel关闭
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully().sync();//关闭EventLoopGroup，释放掉所有资源包括创建的线程
            worker.shutdownGracefully().sync();
        }
    }

}
