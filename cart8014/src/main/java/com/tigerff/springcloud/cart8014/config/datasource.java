package com.tigerff.springcloud.cart8014.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@SuppressWarnings("unchecked")
@Configuration
public class datasource {
    @Bean
    public DataSource getDatasource()
    {
        DataSourceBuilder dataSourceBuilder=DataSourceBuilder.create();
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("321123ww");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/cloudcart?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }

}
