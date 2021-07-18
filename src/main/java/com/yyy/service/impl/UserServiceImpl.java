/**
 * Author: 老洋
 * Date:  2021/7/3 14:36
 */
package com.yyy.service.impl;


import com.yyy.mapper.UserMapper;
import com.yyy.pojo.Type;
import com.yyy.pojo.User;
import com.yyy.service.UserService;
import com.yyy.vo.TypeVO;
import com.yyy.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

/**
 * 用户表：业务层
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //1、查询：通过（用户名、密码）， 查询user对象
    @Override
    public User queryUserByCode(String username, String password) {
        User user = new User();

        // 确定计算方法
        MessageDigest md5 = null;
        String salt = new String("");
        try {
            md5 = MessageDigest.getInstance("MD5");
            Base64.Encoder base64Encoder = Base64.getEncoder();
            salt = base64Encoder.encodeToString(md5.digest("2021-06-05 18:22:34".getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 加密字符串
        user.setUsername(username);             //用户：账号
        user.setPassword(password + salt);     //用户密码：经历过二次加密（创建时间）

        return userMapper.selUserByCode(user);
    }

    //2、查询：有多少个用户
    @Override
    public Long queryUserNums() {
        return userMapper.selUserCount();
    }

    //3、查询：user的（前端传输对象）userVO集合
    @Override
    public List<UserVO> queryAllUserVO() {
        List<UserVO> userVOS = new ArrayList<>();            //创建：返回值
        List<User> users = userMapper.selAllUserNotBlogs();  //查询到：单表查询到user集合

        for(User user:users){                           //遍历：users
            UserVO userVo = new UserVO();
            BeanUtils.copyProperties(user, userVo); //将user值注入：userVo
            userVOS.add(userVo);

        }

        return userVOS;
    }

    //4、调用更新user对象的：业务层代码
    @Override
    public int updateUserInfo(User user) {
        //实现方法：
                //4-1：通过userId获取到（原始user对象）
                //4-2：逐一判断：user对象中的newNickname,newEmail, newAvatar 是否为空，为空使用之前的值
                //4-3：对传过来的密码（加密处理），根据service层的方法

        int state = 0;              //state：作为返回值（若 state > 0 代表修改成功！）
        User oldUser = userMapper.selUserByUserId(user.getId());

        //判断：newNickname 是否为（null || 空）
        if(null == user.getNickname() || "".equals(user.getNickname()))
            user.setNickname(oldUser.getNickname());
        //判断：newEmail 是否为（null || 空）
        if(null == user.getEmail() || "".equals(user.getEmail()))
            user.setEmail(oldUser.getEmail());
        //判断：newAvatar 是否为（null || 空）
        if(null == user.getAvatar() || "".equals(user.getAvatar()))
            user.setAvatar(oldUser.getAvatar());


        //确定加密：方法md5加密
        MessageDigest md5 = null;
        String salt = new String("");
        String newPassword = new String("");
        try {
            md5 = MessageDigest.getInstance("MD5");
            Base64.Encoder base64Encoder = Base64.getEncoder();
            newPassword = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            salt = base64Encoder.encodeToString(md5.digest("2021-06-05 18:22:34".getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 加密字符串
        user.setPassword(newPassword + salt);     //用户密码：经历过二次加密（创建时间）
        state = userMapper.updUserByUser(user);   //更新用户信息
        return state;
    }

    //5、添加用户：通过user对象进行添加
    @Override
    public int insUserByUser(User user) {
        user.setType("管理员");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        MessageDigest md5 = null;
        String salt = new String("");
        String newPassword = new String("");
        try {
            md5 = MessageDigest.getInstance("MD5");
            Base64.Encoder base64Encoder = Base64.getEncoder();
            newPassword = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            salt = base64Encoder.encodeToString(md5.digest("2021-06-05 18:22:34".getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        user.setPassword(newPassword + salt);     //用户密码：经历过二次加密（创建时间）

        return userMapper.insertUserByUser(user);
    }

    //6、删除用户：通过userId
    @Override
    public int delUserByUserId(Long userId) {
        return userMapper.deleteUserByUserId(userId);
    }

}