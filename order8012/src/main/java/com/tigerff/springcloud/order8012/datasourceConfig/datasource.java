package com.tigerff.springcloud.order8012.datasourceConfig;

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
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/cloudorder?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }
    /**
     * 下面配置druid
     */
    //还得配置一个servle
}
