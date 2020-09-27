package com.tigerff.springcloud.gateway8000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/27 0:51
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication8000 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication8000.class,args);
    }
}
