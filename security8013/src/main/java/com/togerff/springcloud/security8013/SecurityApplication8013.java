package com.togerff.springcloud.security8013;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/21 22:42
 */
@SpringBootApplication
@EnableWebSecurity
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class SecurityApplication8013 {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication8013.class,args);
    }
}
