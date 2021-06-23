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

import java.util.List;

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
        blogService.updateViews(id);
        return "blog";
    }

    //加载3篇最新博客
    @GetMapping("/foot/newBlogs")
    public String newBlogs(Model model){
        List<Blog> blogs = blogService.listBlogRecommendTop(3);
        model.addAttribute("blogs", blogs);
        return "/common/front_fragment::newBlogs";
    }
}