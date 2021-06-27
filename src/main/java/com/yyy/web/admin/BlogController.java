/**
 * Author: 老洋
 * Date:  2021/6/5 20:25
 */
package com.yyy.web.admin;

import com.yyy.pojo.Blog;
import com.yyy.pojo.Tag;
import com.yyy.pojo.User;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 后台博客类
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    private static final String  LIST = "admin/blogs";   //所有：文章详情路径
    private static final String  REDIRECT_LIST = "redirect:/admin/blogs";  //重定向：所有文章详情页面
    private static final String  INPUT = "admin/blogs_input";  //新增博客页面

    @Autowired
    private BlogService blogService;        //（博客）业务层：对象

    @Autowired
    private TypeService typeService;        //（类型）业务层：对象

    @Autowired
    private TagService tagService;          //（标签）业务层：对象


    //初始化：添加博客页面的（博客文章对象、标签、分类）
    private void init(Blog blog, Model model){
        model.addAttribute("blog", blog);
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("types", typeService.listType());
    }

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
        return "admin/blogs :: blogList";
    }

    /**
     * 新增博客
     */
    @GetMapping("blogs/input")
    public String input(Model model){
        init(new Blog(), model);
        return INPUT;
    }

    /**
     * 将发布博客：存入数据库
     */
    @PostMapping("/blog")
    public String post(Blog blog, HttpSession session){
        blog.setUser((User)session.getAttribute("user"));   //设置：博客发表用户
        blog.setType(typeService.getType(blog.getType().getId())); //设置：博客分类
        blog.setTags(tagService.listTag(blog.getTagIds()));        //设置：博客标签
        Blog b;

        if(blog.getId() == null){
            b = blogService.saveBlog(blog);                     //保存博客
        }else{
            b = blogService.updateBlog(blog.getId(), blog);     //更新博客
        }

        //判断：操作状态
        if(b == null){
            session.setAttribute("info", "操作：失败");
        }else{
            session.setAttribute("info", "操作：成功");
        }

        return REDIRECT_LIST;
    }


    /**
     * 修改博客 (获取到：旧博客信息)
     */
    @GetMapping("/blogs/{id}/input")
    public String editBlog(@PathVariable("id") Long id, Model model){
        Blog blog = blogService.getBlog(id);

        List<Tag> tags = blog.getTags();
        StringBuilder stringBuilder = new StringBuilder();

        for(Tag tag:tags){
            stringBuilder.append(tag.getId());
            stringBuilder.append(",");
        }
        blog.setType(typeService.getType(blog.getType().getId())); //设置：博客分类
        blog.setTagIds(stringBuilder.toString());       //设置：博客标签

        init(blog, model);          //初始化

        return INPUT;
    }

    /**
     * 删除博客
     */
    @GetMapping("/blogs/{id}/delete")
    public String deleteBlog(@PathVariable Long id){
        blogService.deleteBlog(id);
        return REDIRECT_LIST;           //重定向到：博客详情页面
    }
}