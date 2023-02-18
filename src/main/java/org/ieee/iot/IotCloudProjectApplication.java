package org.ieee.iot;

import lombok.extern.slf4j.Slf4j;
import org.ieee.iot.controller.MqttGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.IntegrationComponentScan;

import java.util.Arrays;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@SpringBootApplication
@IntegrationComponentScan
public class IotCloudProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(IotCloudProjectApplication.class, args);

        MqttGateway mqttGateway = (MqttGateway) context.getBean("mqttGateway");
        mqttGateway.senToMqtt("Hello from Spring Integration", "test");
    }

}
