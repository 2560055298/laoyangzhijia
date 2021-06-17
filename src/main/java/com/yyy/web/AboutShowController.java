/**
 * Author: 老洋
 * Date:  2021/6/17 15:26
 */
package com.yyy.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutShowController {
    //跳转：关于我页面
    @GetMapping("/about")
    public String about(){

        return "about";
    }
}