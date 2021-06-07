/**
 * Author: 老洋
 * Date:  2021/6/5 17:38
 */
package com.yyy.web.admin;


import com.yyy.pojo.User;
import com.yyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


/**
 * 后台登录
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     *  跳转到：登录页面
     */
    @GetMapping
    public String loginPage(){
        return "/admin/login";
    }

    /**
     * 登录后：跳转到的相应页面
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam  String password,
                        HttpSession session) {
        User user = userService.checkUser(username, password);
        if(user != null){
            user.setPassword(null);
            session.setAttribute("user", user);
            return "/admin/index";
        }else{
            session.setAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }

    /**
     * 注销
     */
    @GetMapping("layout")
    public String layout(HttpSession session){
        session.removeAttribute("user");        //清除用户信息
        session.removeAttribute("message");     //清除：消息
        return "redirect:/admin";
    }
}