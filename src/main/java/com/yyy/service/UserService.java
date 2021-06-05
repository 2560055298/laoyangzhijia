package com.yyy.service;

import com.yyy.pojo.User;

public interface UserService {
    //校验：用户名密码
    public User checkUser(String username, String password);
}
