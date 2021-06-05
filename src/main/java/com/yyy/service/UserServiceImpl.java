/**
 * Author: 老洋
 * Date:  2021/6/5 17:07
 */
package com.yyy.service;

import com.yyy.dao.UserRepository;
import com.yyy.pojo.User;
import com.yyy.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}