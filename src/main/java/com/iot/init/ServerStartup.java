package com.iot.init;

import com.iot.thread.TCP;
import com.iot.thread.UDP;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ServerStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        TCP tcp=new TCP();
        UDP udp=new UDP();
        Thread t1=new Thread(tcp);
        Thread t2=new Thread(udp);
        t1.start();
        t2.start();
    }
}
