/**
 * Author: 老洋
 * Date:  2021/6/5 20:25
 */
package com.yyy.web.admin;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台博客类
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    private static final String  LIST = "/admin/blogs";   //所有：文章详情路径
    private static final String  REDIRECT_LIST = "redirect:/dmin/blogs";  //重定向：所有文章详情页面
    private static final String  INPUT = "/admin/blogs_input";  //新增博客页面

    @Autowired
    private BlogService blogService;        //（博客）业务层：对象

    @Autowired
    private TypeService typeService;        //（类型）业务层：对象

    @Autowired
    private TagService tagService;          //（标签）业务层：对象

    /**
     * 跳转；后台博客页面
     * @return
     */
    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        model.addAttribute("types", typeService.listType());

        return LIST;
    }

    /**
     * 跳转；博客信息， 仅刷新（查询）片段
     * @return
     */
    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        model.addAttribute("types", typeService.listType());
        return "/admin/blogs :: blogList";
    }

    /**
     * 新增博客
     */
    @GetMapping("blogs/input")
    public String input(Model model){
        model.addAttribute("blog", new Blog());     //原始：保存博客内容
        model.addAttribute("types", typeService.listType());      //分类内容
        model.addAttribute("tags", tagService.listTag());      //标签内容

        return INPUT;
    }


}