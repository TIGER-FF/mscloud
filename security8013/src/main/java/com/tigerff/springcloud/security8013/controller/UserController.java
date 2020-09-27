package com.tigerff.springcloud.security8013.controller;

import com.tigerff.springcloud.security8013.entities.MyUser;
import com.tigerff.springcloud.security8013.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author tigerff
 * @version 1.0
 * @date 2020/9/24 13:50
 */
@Controller
@Slf4j
public class UserController {
    private final String PREFIX_LOG = "log/";


    @Autowired
    UserService userService;

    /**
     * 更新用户数据--并返回到用户的资料页面
     * 让用户的姓名不能修改
     * @return
     */
    @PutMapping("/log/user")
    public String updateUser(Map<String,Object> map, HttpServletResponse response, @RequestBody MyUser myUser) throws IOException {
        log.info("*****"+myUser.toString());
        Integer integer = userService.updateUserByName(myUser);
        String data="{\"data\":\"update success\"}";
        log.info("******"+data);
        if(integer==1)
            response.getWriter().write(data);
        return null;
    }

    /**
     * 插入用户，就是注册后将用户存储在数据库中
     * @param response
     * @param myUser
     * @return
     * @throws IOException
     */
    @PostMapping("/index/user/insert")
    public String insertUser1(HttpServletResponse response,@RequestBody MyUser myUser) throws IOException {
        Integer integer = userService.insertUser(myUser);
        log.info("*****"+myUser.toString());
        String data="{\"data\":\"update success\"}";
        log.info("******"+data);
        if(integer==1)
            response.getWriter().write(data);
        return null;
    }
}
