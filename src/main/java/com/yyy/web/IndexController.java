/**
 * Author: 老洋
 * Date:  2021/6/1 14:02
 */
package com.yyy.web;

import com.yyy.pojo.Blog;
import com.yyy.service.BlogService;
import com.yyy.service.TagService;
import com.yyy.service.TypeService;
import com.yyy.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    BlogService blogService;            //博客：业务层对象

    @Autowired
    TypeService typeService;            //类型：业务层对象

    @Autowired
    TagService tagService;              //标签：业务层对象

    //跳转主页
    @GetMapping("/")
    public String index(
            @PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                    Pageable pageable, Model model){

       model.addAttribute("page", blogService.listBlog(pageable));
       model.addAttribute("type", typeService.listTypeTop(6));
        model.addAttribute("tag", tagService.listTagTop(6));

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