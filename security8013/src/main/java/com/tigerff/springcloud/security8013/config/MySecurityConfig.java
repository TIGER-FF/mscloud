package com.tigerff.springcloud.security8013.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 2、编写SpringSecurity的配置类；
 * 		@EnableWebSecurity   extends WebSecurityConfigurerAdapter
 * 3、控制请求的访问权限：
 * 		configure(HttpSecurity http) {
 * 		 	http.authorizeRequests().antMatchers("/").permitAll()
 * 		 		.antMatchers("/level1/**").hasRole("VIP1")
 * 		}
 * 4、定义认证规则：
 * 		configure(AuthenticationManagerBuilder auth){
 * 		 	auth.inMemoryAuthentication()
 * 		 		.withUser("zhangsan").password("123456").roles("VIP1","VIP2")
 * 		}
 * 5、开启自动配置的登陆功能：
 * 		configure(HttpSecurity http){
 * 		 	http.formLogin();
 * 		}
 * 6、注销：http.logout();
 * 7、记住我：Remeberme()；
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                //对静态的文件进行放行
                .antMatchers("/","/static/css/**","/static/js/**","/static/images/**","/static/fonts/**").permitAll()
                .antMatchers("/index/**").permitAll()
                .anyRequest().authenticated();// 其他地址的访问均需验证权限;


        //开启自动配置的登陆功能，效果，如果没有登陆，没有权限就会来到登陆页面
        http.formLogin();
//                .usernameParameter("userName").passwordParameter("userPassword")
//                .loginPage("/index/login");
        //1、/login来到登陆页
        //2、重定向到/login?error表示登陆失败
        //3、更多详细规定
        //4、默认post形式的 /login代表处理登陆
        //5、一但定制loginPage；那么 loginPage的post请求就是登陆


        //开启自动配置的注销功能。
        http.logout().logoutSuccessUrl("/");//注销成功以后来到首页
        //1、访问 /logout 表示用户注销，清空session
        //2、注销成功会返回 /login?logout 页面；

        //开启记住我功能
        http.rememberMe();
        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
        //点击注销会删除cookie

    }
    /**
     * 自定义认证数据源---查数据库的
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailService());
                //.passwordEncoder(passwordEncoder());
    }

    @Bean
    public MyUserServiceImpl userDetailService (){
        return new MyUserServiceImpl() ;
    }

//    /**
//     * 密码加密
//     */
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
    //定义认证规则---乱写的，没有查数据库
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //super.configure(auth);
//        auth.inMemoryAuthentication()
//                .withUser("zhangsan").password("123456").roles("VIP1","VIP2")
//                .and()
//                .withUser("lisi").password("123456").roles("VIP2","VIP3")
//                .and()
//                .withUser("wangwu").password("123456").roles("VIP1","VIP3");
//
//    }
}
