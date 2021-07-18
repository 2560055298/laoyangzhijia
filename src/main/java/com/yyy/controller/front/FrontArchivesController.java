/**
 * Author: 老洋
 * Date:  2021/7/1 15:02
 */
package com.yyy.controller.front;


import com.yyy.pojo.Blog;
import com.yyy.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 归档类（前端）： controller
 */

@Controller
public class FrontArchivesController {
    @Autowired
    private BlogService blogService;

    //1、跳转：归档页面
    @RequestMapping(value = {"/front/archives", "/front/archives/{year}"})
    public String archives(Model model,
                           @PathVariable(required = false) Integer year) {

        List<Integer> years = blogService.queryBlogYears();
        if(null != years && years.size() != 0 && null == year){      //第一次：访问归档页面时，默认查询（最近年份）
            year = years.get(0);
        }

        List<Blog> blogs = blogService.queryBlogsByYear(year);

        model.addAttribute("years", years);     //归档的：年份
        model.addAttribute("blogs", blogs);     //该年份：归档的博客
        model.addAttribute("currentYear", year);

        return "front/archives";
    }

}