/**
 * Author: 老洋
 * Date:  2021/6/1 14:02
 */
package com.yyy.web;

import com.yyy.pojo.Blog;
import com.yyy.service.BlogService;
import com.yyy.service.TagService;
import com.yyy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String index(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                    Pageable pageable, Model model){

       model.addAttribute("page", blogService.listBlog(pageable));
       model.addAttribute("types", typeService.listTypeTop(6));
       model.addAttribute("tags", tagService.listTagTop(6));
       model.addAttribute("recomments", blogService.listBlogRecommendTop(5));

       return "index";
    }


    //跳转：全局查询页面
    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                                     Pageable pageable, String query ,Model model){

        model.addAttribute("page", blogService.listBlog("%"+query+"%", pageable));
        model.addAttribute("query",query);
        return "/search";
    }


    //跳转：博客文章页面
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        Blog blog = blogService.getAndConvert(id);
        model.addAttribute("blog", blog);

        return "blog";
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



}