package com.tigerff.springcloud.cart8014;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/26 7:50
 */
@SpringBootApplication
@EnableEurekaClient
public class CartApplication8014 {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication8014.class,args);
    }
}
