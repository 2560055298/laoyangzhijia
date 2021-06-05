/**
 * Author: 老洋
 * Date:  2021/6/1 14:02
 */
package com.yyy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //跳转主页
    @GetMapping("/")
    public String index(){

        System.out.println("-----------index-------------");
        return "index";
    }

    //跳转：类型页面
    @GetMapping("/types")
    public String types(){
        System.out.println("-----------types-------------");
        return "types";
    }

    //跳转：标签页面
    @GetMapping("/tags")
    public String tags(){
        System.out.println("-----------tags-------------");
        return "tags";
    }

    //跳转：归档页面
    @GetMapping("/archives")
    public String archives(){
        System.out.println("-----------archives-------------");
        return "archives";
    }


    //跳转：关于我页面
    @GetMapping("/about")
    public String about(){
        System.out.println("-----------about-------------");
        return "about";
    }

    //跳转：关于我页面
    @GetMapping("/blog")
    public String blog(){
        System.out.println("-----------blog-------------");
        return "blog";
    }

}