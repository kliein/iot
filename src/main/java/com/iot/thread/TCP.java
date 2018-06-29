package com.iot.thread;

import com.iot.config.SocketConfig;
import com.iot.socket.TCPServer;
import org.springframework.beans.factory.annotation.Autowired;

public class TCP implements Runnable{

    @Autowired
    private SocketConfig socketConfig;

    private static final int TCP_PORT=10002;

    @Override
    public void run() {
        try {
            new TCPServer(TCP_PORT).start();//创建UDP
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
