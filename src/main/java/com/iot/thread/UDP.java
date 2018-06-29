package com.iot.thread;

import com.iot.config.SocketConfig;
import com.iot.socket.UDPServer;
import org.springframework.beans.factory.annotation.Autowired;

public class UDP implements Runnable {

    @Autowired
    private SocketConfig socketConfig;

    private static final int UDP_PORT=10001;

    @Override
    public void run() {

        try {
            new UDPServer(UDP_PORT).start();//创建UDP
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
