package com.tigerff.springcloud.security8013.config;

import com.tigerff.springcloud.security8013.entities.MyUser;
import com.tigerff.springcloud.security8013.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 检验用户
 * 检验成功后对用户进行封装，加上用户的权限进行返回
 */
@Component
@Order(0)
public class MyUserServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 这里可以捕获异常，使用异常映射，抛出指定的提示信息
        // 用户校验的操作
        // 从数据库中用用户姓名查询出用户
        MyUser myUser = userService.getUserByName(s);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>() ;
        /*
         * Spring Boot 2.0 版本踩坑
         * 必须要 ROLE_ 前缀， 因为 hasRole("LEVEL1")判断时会自动加上ROLE_前缀变成 ROLE_LEVEL1 ,
         * 如果不加前缀一般就会出现403错误
         * 在给用户赋权限时,数据库存储必须是完整的权限标识ROLE_LEVEL1
         */
        if (myUser != null){
                grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_LOG")) ;
        }
        else
            throw new UsernameNotFoundException("用户名不存在");
        return new User(myUser.getUserName(), myUser.getUserPassword(),grantedAuthorityList);
    }
}
