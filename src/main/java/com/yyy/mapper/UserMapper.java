package com.yyy.mapper;

import com.yyy.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表：持久层
 */
@Repository
public interface UserMapper {
    //1、查询用户：通过用户对象（账号、密码）
    User selUserByCode(User user);

    //2、查询：用户的数目
    Long selUserCount();

    //3、查询：user集合， 不包含blogs字段
    List<User> selAllUserNotBlogs();

    //4、查询：通过userId查询user对象
    User selUserByUserId(Long userId);

    //5、更新：通过user (更新用户信息)
    int updUserByUser(User user);

    //6、添加用户：通过user对象进行添加
    int insertUserByUser(User user);

    //7、删除用户：通过userId
    int deleteUserByUserId(Long Userid);
}
