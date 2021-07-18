/**
 * Author: 老洋
 * Date:  2021/7/3 19:17
 */
package com.yyy.controller.after;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 处理后台退出：controller
 */
@Controller
public class AfterLogoutController {
    @RequestMapping("/after/logout")
    public String layout(HttpSession session){
        session.invalidate();

        return "redirect:/front/login";
    }
}