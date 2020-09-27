package com.tigerff.springcloud.goods8011;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/20 14:52
 */
@SpringBootApplication
@EnableCaching//开启缓存
@EnableEurekaClient
public class GoodsApplication8011 {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication8011.class,args);
    }
}
