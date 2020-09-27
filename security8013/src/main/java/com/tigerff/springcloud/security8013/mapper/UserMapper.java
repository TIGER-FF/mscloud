package com.tigerff.springcloud.security8013.mapper;


import com.tigerff.springcloud.security8013.entities.MyUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    /**
     *根据用户的姓名去获取用户的信息
     * @param userName
     * @return
     */
    @Select("select * from table_user where user_name=#{userName}")
    MyUser getUserByName(@Param("userName") String userName);
    /**
     * 根据用户的姓名去对用户信息去更新
     * @param myUser
     * @return
     */
    @Update({"update table_user set user_phone=#{userPhone},user_email=#{userEmail},user_qq=#{userQq} where user_name=#{userName}"})
    Integer updateUserByName(MyUser myUser);


    /**
     * 将注册的用户加入数据库
     *
     * @param myUser
     * @return
     */
    @Insert("insert into table_user values(null,#{userName},#{userPassword},#{userPhone},#{userEmail},#{userQq})")
    Integer insertUser(MyUser myUser);

}
