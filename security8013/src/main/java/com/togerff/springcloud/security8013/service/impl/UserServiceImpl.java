package com.togerff.springcloud.security8013.service.impl;


import com.tigerff.springcloud.commons.entities.MyUser;
import com.togerff.springcloud.security8013.mapper.UserMapper;
import com.togerff.springcloud.security8013.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户的姓名去获取用户的信息
     * @param userName
     * @return
     */
    @Override
    public MyUser getUserByName(String userName) {
         return userMapper.getUserByName(userName);
    }

    /**
     * 根据用户的姓名去对用户信息去更新
     *
     * @param myUser
     * @return
     */
    @Override
    public Integer updateUserByName(MyUser myUser) {
        Integer da=1;
        return userMapper.updateUserByName(myUser);
    }

    /**
     * 将注册的用户加入数据库
     *
     * @param myUser
     * @return
     */
    @Override
    public Integer insertUser(MyUser myUser) {
        return userMapper.insertUser(myUser);
    }
}
