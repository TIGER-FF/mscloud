package com.tigerff.springcloud.order8012;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/21 10:43
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderApplication8012 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication8012.class,args);
    }
}
