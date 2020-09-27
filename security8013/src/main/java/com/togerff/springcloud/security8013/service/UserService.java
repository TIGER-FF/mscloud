package com.togerff.springcloud.security8013.service;

import com.tigerff.springcloud.commons.entities.CartItem;
import com.tigerff.springcloud.commons.entities.MyUser;

import java.util.List;


public interface UserService {
    /**
     * 根据用户的姓名去获取用户的信息
     * @param userName
     * @return
     */
    MyUser getUserByName(String userName);

    /**
     * 根据用户的姓名去对用户信息去更新
     * @param myUser
     * @return
     */
    Integer updateUserByName(MyUser myUser);

    /**
     * 将注册的用户加入数据库
     * @param myUser
     * @return
     */
    Integer insertUser(MyUser myUser);


}
