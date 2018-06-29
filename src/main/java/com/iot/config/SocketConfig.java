package com.iot.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "socket")
public class SocketConfig {

    private int Udpport;

    private int Tcpport;

}
