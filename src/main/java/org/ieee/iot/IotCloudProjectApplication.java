package org.ieee.iot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class IotCloudProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotCloudProjectApplication.class, args);
    }

}
