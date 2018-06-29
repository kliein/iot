package com.iot.config;


import com.iot.init.ServerStartup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ListenerConfig {

    @Bean
    public ServerStartup serverStartup(){
        return new ServerStartup();
    }
}
