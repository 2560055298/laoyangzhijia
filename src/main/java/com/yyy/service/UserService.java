package com.yyy.service;

import com.yyy.pojo.User;
import com.yyy.vo.UserVO;

import java.util.List;

/**
 * 用户表：业务层接口
 */
public interface UserService {
    //1、查询用户：通过username 和 password
    User queryUserByCode(String username, String password);

    //2、查询：有多少个用户
    Long queryUserNums();

    //3、查询：user的（前端传输对象）userVO集合
    List<UserVO> queryAllUserVO();

    //4、调用更新user对象的：业务层代码
    int updateUserInfo(User user);

    //5、添加用户：通过user对象进行添加
    int insUserByUser(User user);

    //6、删除用户：通过userId
    int delUserByUserId(Long userId);
}
