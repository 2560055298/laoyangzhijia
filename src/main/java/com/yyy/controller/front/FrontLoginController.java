/**
 * Author: 老洋
 * Date:  2021/7/2 16:18
 */
package com.yyy.controller.front;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class FrontLoginController {
    @GetMapping("/front/login")
    public String login(HttpSession session){
        //session.invalidate();               //让user失效

        if(session.getAttribute("user") != null){
            return "after/index";
        }

        return "front/login";
    }
}