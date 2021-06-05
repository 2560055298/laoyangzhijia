/**
 * Author: 老洋
 * Date:  2021/6/5 20:25
 */
package com.yyy.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台博客类
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    /**
     * 跳转；后台博客页面
     * @return
     */
    @GetMapping("/blogs")
    public String blogs(){
        return "/admin/blogs";
    }
}