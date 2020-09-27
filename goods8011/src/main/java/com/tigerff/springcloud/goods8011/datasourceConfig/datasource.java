package com.tigerff.springcloud.goods8011.datasourceConfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("unchecked")
@Configuration
public class datasource {
    @Bean
    public DataSource getDatasource()
    {
        DataSourceBuilder dataSourceBuilder=DataSourceBuilder.create();
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("321123ww");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/cloudgoods?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }
    /**
     * 下面配置druid
     */
    //还得配置一个servlet


    public ServletRegistrationBean statViewServlet()
    {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        //网页输入/druid回到一个登录界面下面的就是密码
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");
        //默认就是允许所有访问
        bean.setInitParameters(initParams);
        return bean;
        //3、整合MyBatis 步骤： 1）、配置数据源相关属性（见上一节Druid） 2）、给数据库建表 3）、创建JavaBean 4）、注解版return bean;
    }
    //话要配置一个filter

    public FilterRegistrationBean webStatFilter()
    {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
